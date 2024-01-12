package koda.kafkaTest.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String message;

    private String name;

    private int id;

    @Override
    public String toString() {
        return "User{" +
                "message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
