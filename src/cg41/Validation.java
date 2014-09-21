package cg41;

public class Validation {

    private boolean isInDatabase;

    public Validation() {
    }

    /**
     * This method requires a string input for the first name and will return a
     * boolean value as to whether or not it matches the validation pattern
     */
    public boolean validateFirstName(String inFirstName) {
        return inFirstName.matches("[A-Z][a-zA-Z]{1,9}");
    }

    /**
     * This method requires a string input for the last name and will return a
     * boolean value as to whether or not it matches the validation pattern
     */
    public boolean validateSurname(String inSurnameName) {
        return inSurnameName.matches("([a-zA-z'-]{1,2})([a-zA-Z '-]{1,18})");
    }

    /**
     * This method requires a string input for the course name and will return a
     * boolean value as to whether or not it matches the validation pattern
     */
    public boolean validateCourseName(String inCourseName) {
        return inCourseName.matches("([a-zA-z]{1,2})([a-zA-Z0-9 '-]{1,20})");
    }
    /**
     * This method requires a string input for the category name and will return a
     * boolean value as to whether or not it matches the validation pattern
     */
    public boolean validateCategoryName(String inCatName) {
        return inCatName.matches("([a-zA-z]{1,2})([a-zA-Z0-9 '-]{1,20})");
    }

    public boolean isGovInDB(String inName) {
        isInDatabase = false;
        return isInDatabase;
    }

    public boolean isCourseInDB(String inName) {
        isInDatabase = false;
        return isInDatabase;
    }

    public boolean isCatInDB(String inName) {
        isInDatabase = false;
        return isInDatabase;
    }
}
