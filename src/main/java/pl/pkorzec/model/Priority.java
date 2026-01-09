package pl.pkorzec.model;

public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    public static Priority fromString(String value){
        if(value == null || value.isBlank()){
            return MEDIUM;
        }
        try{
            return Priority.valueOf(value.trim().toUpperCase());
        } catch(IllegalArgumentException e){
            return MEDIUM;
        }
    }

}
