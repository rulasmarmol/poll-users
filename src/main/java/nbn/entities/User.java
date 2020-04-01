package nbn.entities;

public class User {
  public String id;

  public String name;
  public int age;

  public User() {}

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%s, name='%s', age='%d']",
        id, name, age);
  }

}