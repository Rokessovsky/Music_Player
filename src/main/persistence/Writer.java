package persistence;

import model.User;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Represents a class that writes data to a JSON file
// Reference: https://howtodoinjava.com/library/json-simple-read-write-json-examples/
//            TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
//           BCS-Degree Navigator (https://github.com/def-not-ys/BCS-Degree-Navigator)
public class Writer {
    FileWriter file;


    //EFFECTS: construct a file with given location.
    public Writer(String location) throws IOException {
        file = new FileWriter(location);
    }

    // MODIFIES: this
    // EFFECTS: writes the users into JSON file
    @SuppressWarnings("unchecked")
    public void write(List<User> users) throws IOException {

        JSONObject allUsers = new JSONObject();
        for (User user: users) {

            JSONObject data = user.userDetails();
            allUsers.put(user.getName(), data);


        }

        file.write(allUsers.toString());
        file.flush();
    }

    // MODIFIES: this
    // EFFECTS: close the print write
    // NOTE: MUST be called when done writing
    public void close() throws IOException {
        file.close();
    }


}
