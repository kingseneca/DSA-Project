// Contact.java
class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private long ID;
    private boolean blocked;

    public Contact(String name, String phoneNumber, String email, long ID) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ID = ID;
        this.blocked = false; // Default to not blocked
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public long getID() {
        return ID;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Phone Number: " + phoneNumber + "\n" + "Email: "
                + email + "\nID: " + ID + "\nBlocked: " + (blocked ? "Yes" : "No");
    }
}
