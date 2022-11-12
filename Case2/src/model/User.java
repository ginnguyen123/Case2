package model;

import java.time.Instant;
import java.util.Date;

public class User {
    private long id;
    private String userName;
    private String phoneNumbers;
    private String emails;
    private Date creatAt;
    private Instant updateAt;
    public User(){}
    public User(long id, String userName, String phoneNumbers, String emails, Date creatAt, Instant updateAt){
        this.id = id;
        this.userName = userName;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    public String getEmails() {
        return emails;
    }
    public void setEmails(String emails) {
        this.emails = emails;
    }
    public Date getCreatAt() {
        return creatAt;
    }
    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }
    public Instant getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        //User(long id, String userName, String phoneNumbers, String emails,
        // Date creatAt, Instant updateAt)
        // đang sai định dạng %s cho kiểu dữ kiệu date và intanse
        return String.format("%f,%s,%s,%s,%s,%s", this.id,
                this.userName,
                this.phoneNumbers,
                this.emails,
                this.creatAt,
                this.updateAt);
    }
}
