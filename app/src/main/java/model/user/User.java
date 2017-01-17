/*
 * MAGRATHEA - DAM
 */
package model.user;

import java.util.ArrayList;
import model.utils.MyDate;

/**
 * Store data for one user
 * @author Iván Villa
 */
public class User {
    private int id;
    private String publicName;
    private String name;
    private String password;
    private String phone;
    private String eMail;
    private String privateDescription;
    private String publicDescription;
    private MyDate memberSince;
    private String role;
    private String language;
    private MyDate dataPassword;
    private boolean markedForDeletion;
    private MyDate clearRequestData;
    private boolean ads;
    private ArrayList<Sanction> sanctions;
    private ArrayList <AchievementUser> achievements;

    /**
     * Constructor with parameters
     * @param id id
     * @param publicName public name
     * @param name real name
     * @param phone phone
     * @param eMail e-mail
     * @param privateDescription private description
     * @param publicDescription public description
     * @param memberSince member since
     * @param role user role
     * @param language language of the user
     * @param dataPassword user password
     * @param markedForDeletion marked for delete
     * @param clearRequestData delete request date
     * @param ads if the user allow ads
     * @param sanctions user sanctions
     * @param achievements user achievements
     */
    public User(int id, String publicName, String name, String password, String phone, String eMail, String privateDescription, String publicDescription, MyDate memberSince, String role, String language, MyDate dataPassword, boolean markedForDeletion, MyDate clearRequestData, boolean ads, ArrayList<Sanction> sanctions, ArrayList<AchievementUser> achievements) {
        this.id = id;
        this.publicName = publicName;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.eMail = eMail;
        this.privateDescription = privateDescription;
        this.publicDescription = publicDescription;
        this.memberSince = memberSince;
        this.role = role;
        this.language = language;
        this.dataPassword = dataPassword;
        this.markedForDeletion = markedForDeletion;
        this.clearRequestData = clearRequestData;
        this.ads = ads;
        this.sanctions = sanctions;
        this.achievements = achievements;
    }
    
    /**
     * Constructor simple
     */
    public User() {
    }

    // GETTERS AND SETTERS

    /**
     * Get id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set nickname
     * @return nickname
     */
    public String getPublicName() {
        return publicName;
    }

    /**
     * Get nickname
     * @param publicName Get nickname
     */
    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    /**
     * Set user name
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Get user name
     * @param name user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get phone number
     * @return phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phone number
     * @param phone phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get e-mail adress
     * @return e-mail adress
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * Set e-mail adress
     * @param eMail  e-mail adress
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * Get private description
     * @return  private description
     */
    public String getPrivateDescription() {
        return privateDescription;
    }

    /**
     * Set private description
     * @param privateDescription private description
     */
    public void setPrivateDescription(String privateDescription) {
        this.privateDescription = privateDescription;
    }

    /**
     * Get public description
     * @return public description
     */
    public String getPublicDescription() {
        return publicDescription;
    }

    /**
     * Set public description
     * @param publicDescription descripción pública del usuario
     */
    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    /**
     * Get date of sign
     * @return date of sign
     */
    public MyDate getMemberSince() {
        return memberSince;
    }

    /**
     * Set date of sign
     * @param memberSince date of sign
     */
    public void setMemberSince(MyDate memberSince) {
        this.memberSince = memberSince;
    }

    /**
     * Get user role
     * @return user role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set user role
     * @param role user role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get user language
     * @return user language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set user language
     * @param language user language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Get password date
     * @return password date
     */
    public MyDate getDataPassword() {
        return dataPassword;
    }

    /**
     * Set password date
     * @param dataPassword password date
     */
    public void setDataPassword(MyDate dataPassword) {
        this.dataPassword = dataPassword;
    }

    /**
     * Get if the user is marked for deletion
     * @return true (yes) or false (no)
     */
    public boolean isMarkedForDeletion() {
        return markedForDeletion;
    }

    /**
     * Set if the user is marked for deletion
     * @param markedForDeletion true (yes) or false (no)
     */
    public void setMarkedForDeletion(boolean markedForDeletion) {
        this.markedForDeletion = markedForDeletion;
    }

    /**
     * Get deletion request data
     * @return deletion request data
     */
    public MyDate getClearRequestData() {
        return clearRequestData;
    }

    /**
     * Set deletion request data
     * @param clearRequestData deletion request data
     */
    public void setClearRequestData(MyDate clearRequestData) {
        this.clearRequestData = clearRequestData;
    }

    /**
     * Get if the user wants to get ads
     * @return true (yes), false (no)
     */
    public boolean getAds() {
        return ads;
    }

    /**
     * Set if the user wants to get ads
     * @param ads true (yes), false (no)
     */
    public void setAds(boolean ads) {
        this.ads = ads;
    }

    /**
     * Get sanctions
     * @return sanctions
     */
    public ArrayList<Sanction> getSanctions() {
        return sanctions;
    }

    /**
     * Set sanctions
     * @param sanctions sanctions
     */
    public void setSanctions(ArrayList<Sanction> sanctions) {
        this.sanctions = sanctions;
    }

    /**
     * Get achievements
     * @return achievements
     */
    public ArrayList<AchievementUser> getAchievements() {
        return achievements;
    }

    /**
     * Set achievements
     * @param achievements achievements
     */
    public void setAchievements(ArrayList<AchievementUser> achievements) {
        this.achievements = achievements;
    }

    /**
     * Return password
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
