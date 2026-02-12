BEGIN;

--1) Create inbox task lists (one per user) if missing

INSERT INTO task_lists(name, owner_user_id)
SELECT 'Inbox', u.id
FROM "users" u
WHERE NOT EXISTS(
    SELECT 1
    FROM task_list tl
    WHERE tl.owner_user_id = u.id
        AND tl.name = 'Inbox'
);
-- 2) Assign existing tasks to their owner's Inbox
UPDATE tasks t
SET task_list_id = tl.id
FROM task_list tl
WHERE tl.owner_user_id = t.user_id
    AND tl.name = 'Inbox'
    AND t.task_list_id IS NULL;

COMMIT;

