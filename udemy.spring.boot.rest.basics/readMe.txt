DAO is an abbreviation for Data Access Object, so it should encapsulate the logic for retrieving, 
saving and updating data in your data storage (a database, a file-system, whatever). 

Here is an example how the DAO and DTO interfaces would look like:

interface PersonDTO {
    String getName();
    void setName(String name);
    //.....
}

interface PersonDAO {
    PersonDTO findById(long id);
    void save(PersonDTO person);
    //.....
}