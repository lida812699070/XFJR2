package tomcat360.com.hyxfjr.model.entity;

/**
 * Title:LoginEntity
 * Package:com.tomcat360.model.entity
 * Description:TODO
 * Author: ylt@tomcat360.com
 * Date: 2016/3/24
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */
public class LoginEntity extends BaseBean {

    /**
     * sessionId : FC96E327DE0339EAB8BB1F3058D4F0E8
     * user : {"smallPic":null,"techSignStatus":0,"authKey":null,"vipManualSet":0,"passwordResetToken":null,"cardBindingStatus":0,"registryhold":null,"emailBindingStatus":null,"passwordHash":"410c33bcce84e09e688b3d5f41625919c0dd8a370f029f4bedcf2ad1f9da6a28a91b705aa8a2cc107d03405acace21bc5380553527a14ef4ee2925017e7d7dd3","userType":null,"accountNumber":"0","username":"13567117400","businessLicense":0,"creditReport":0,"income":0,"age":"","litpic":null,"role":null,"customService":null,"industry":null,"credit":null,"autoType":null,"loginName":null,"status":0,"updateTime":null,"isTouzi":0,"salesman":null,"mobileBindingStatus":1,"email":null,"inviteCode":"n47qrKx3sMGEWzm","lastLogintime":1488786372,"room":0,"mobile":"13567117400","position":null,"scale":null,"trustUsrCustId":null,"birthday":null,"bigPic":null,"sex":null,"isRecharge":0,"realVerifyStatus":0,"accountBook":0,"maritalStatus":0,"education":null,"id":13,"annualIncome":null,"organization":null,"collateral":0,"fieldCertification":0,"createdAt":1488350970,"onPic":null,"idCard":null,"moneymoremoreId":"1","vipGrade":0,"inviteUserId":null,"workHours":null,"cardIdBase":null,"updatedAt":null,"passwordPayHash":"410c33bcce84e09e688b3d5f41625919c0dd8a370f029f4bedcf2ad1f9da6a28a91b705aa8a2cc107d03405acace21bc5380553527a14ef4ee2925017e7d7dd3","createdIp":"192.168.1.1","loginAccountId":null,"realname":null,"companyCategory":null,"bankAccount":0,"drivingLicense":0}
     */

    private DataEntity data;
    /**
     * data : {"sessionId":"FC96E327DE0339EAB8BB1F3058D4F0E8","user":{"smallPic":null,"techSignStatus":0,"authKey":null,"vipManualSet":0,"passwordResetToken":null,"cardBindingStatus":0,"registryhold":null,"emailBindingStatus":null,"passwordHash":"410c33bcce84e09e688b3d5f41625919c0dd8a370f029f4bedcf2ad1f9da6a28a91b705aa8a2cc107d03405acace21bc5380553527a14ef4ee2925017e7d7dd3","userType":null,"accountNumber":"0","username":"13567117400","businessLicense":0,"creditReport":0,"income":0,"age":"","litpic":null,"role":null,"customService":null,"industry":null,"credit":null,"autoType":null,"loginName":null,"status":0,"updateTime":null,"isTouzi":0,"salesman":null,"mobileBindingStatus":1,"email":null,"inviteCode":"n47qrKx3sMGEWzm","lastLogintime":1488786372,"room":0,"mobile":"13567117400","position":null,"scale":null,"trustUsrCustId":null,"birthday":null,"bigPic":null,"sex":null,"isRecharge":0,"realVerifyStatus":0,"accountBook":0,"maritalStatus":0,"education":null,"id":13,"annualIncome":null,"organization":null,"collateral":0,"fieldCertification":0,"createdAt":1488350970,"onPic":null,"idCard":null,"moneymoremoreId":"1","vipGrade":0,"inviteUserId":null,"workHours":null,"cardIdBase":null,"updatedAt":null,"passwordPayHash":"410c33bcce84e09e688b3d5f41625919c0dd8a370f029f4bedcf2ad1f9da6a28a91b705aa8a2cc107d03405acace21bc5380553527a14ef4ee2925017e7d7dd3","createdIp":"192.168.1.1","loginAccountId":null,"realname":null,"companyCategory":null,"bankAccount":0,"drivingLicense":0}}
     * Cookie : logined_password=410C33BCCE84E09E688B3D5F41625919C0DD8A370F029F4BEDCF2AD1F9DA6A28A91B705AA8A2CC107D03405ACACE21BC5380553527A14EF4EE2925017E7D7DD3
     * code : 0
     * totalPage : 0
     * msg : success
     */

    private String Cookie;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getCookie() {
        return Cookie;
    }

    public void setCookie(String Cookie) {
        this.Cookie = Cookie;
    }


    public static class DataEntity {
        private String sessionId;
        /**
         * smallPic : null
         * techSignStatus : 0
         * authKey : null
         * vipManualSet : 0
         * passwordResetToken : null
         * cardBindingStatus : 0
         * registryhold : null
         * emailBindingStatus : null
         * passwordHash : 410c33bcce84e09e688b3d5f41625919c0dd8a370f029f4bedcf2ad1f9da6a28a91b705aa8a2cc107d03405acace21bc5380553527a14ef4ee2925017e7d7dd3
         * userType : null
         * accountNumber : 0
         * username : 13567117400
         * businessLicense : 0
         * creditReport : 0
         * income : 0
         * age :
         * litpic : null
         * role : null
         * customService : null
         * industry : null
         * credit : null
         * autoType : null
         * loginName : null
         * status : 0
         * updateTime : null
         * isTouzi : 0
         * salesman : null
         * mobileBindingStatus : 1
         * email : null
         * inviteCode : n47qrKx3sMGEWzm
         * lastLogintime : 1488786372
         * room : 0
         * mobile : 13567117400
         * position : null
         * scale : null
         * trustUsrCustId : null
         * birthday : null
         * bigPic : null
         * sex : null
         * isRecharge : 0
         * realVerifyStatus : 0
         * accountBook : 0
         * maritalStatus : 0
         * education : null
         * id : 13
         * annualIncome : null
         * organization : null
         * collateral : 0
         * fieldCertification : 0
         * createdAt : 1488350970
         * onPic : null
         * idCard : null
         * moneymoremoreId : 1
         * vipGrade : 0
         * inviteUserId : null
         * workHours : null
         * cardIdBase : null
         * updatedAt : null
         * passwordPayHash : 410c33bcce84e09e688b3d5f41625919c0dd8a370f029f4bedcf2ad1f9da6a28a91b705aa8a2cc107d03405acace21bc5380553527a14ef4ee2925017e7d7dd3
         * createdIp : 192.168.1.1
         * loginAccountId : null
         * realname : null
         * companyCategory : null
         * bankAccount : 0
         * drivingLicense : 0
         */

        private UserEntity user;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public UserEntity getUser() {
            return user;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public static class UserEntity {
            private String smallPic;
            private int techSignStatus;
            private String authKey;
            private int vipManualSet;
            private String passwordResetToken;
            private int cardBindingStatus;
            private String registryhold;
            private String emailBindingStatus;
            private String passwordHash;
            private String userType;
            private String accountNumber;
            private String username;
            private int businessLicense;
            private int creditReport;
            private int income;
            private String age;
            private String litpic;
            private String role;
            private String customService;
            private String industry;
            private String credit;
            private String autoType;
            private String loginName;
            private int status;
            private String updateTime;
            private int isTouzi;
            private String salesman;
            private int mobileBindingStatus;
            private String email;
            private String inviteCode;
            private int lastLogintime;
            private int room;
            private String mobile;
            private String position;
            private String scale;
            private String trustUsrCustId;
            private String birthday;
            private String bigPic;
            private String sex;
            private int isRecharge;
            private int realVerifyStatus;
            private int accountBook;
            private int maritalStatus;
            private String education;
            private String id;
            private String annualIncome;
            private String organization;
            private int collateral;
            private int fieldCertification;
            private int createdAt;
            private String onPic;
            private String idCard;
            private String moneymoremoreId;
            private int vipGrade;
            private String inviteUserId;
            private String workHours;
            private String cardIdBase;
            private String updatedAt;
            private String passwordPayHash;
            private String createdIp;
            private String loginAccountId;
            private String realname;
            private String companyCategory;
            private int bankAccount;
            private int drivingLicense;

            public String getSmallPic() {
                return smallPic;
            }

            public void setSmallPic(String smallPic) {
                this.smallPic = smallPic;
            }

            public int getTechSignStatus() {
                return techSignStatus;
            }

            public void setTechSignStatus(int techSignStatus) {
                this.techSignStatus = techSignStatus;
            }

            public String getAuthKey() {
                return authKey;
            }

            public void setAuthKey(String authKey) {
                this.authKey = authKey;
            }

            public int getVipManualSet() {
                return vipManualSet;
            }

            public void setVipManualSet(int vipManualSet) {
                this.vipManualSet = vipManualSet;
            }

            public String getPasswordResetToken() {
                return passwordResetToken;
            }

            public void setPasswordResetToken(String passwordResetToken) {
                this.passwordResetToken = passwordResetToken;
            }

            public int getCardBindingStatus() {
                return cardBindingStatus;
            }

            public void setCardBindingStatus(int cardBindingStatus) {
                this.cardBindingStatus = cardBindingStatus;
            }

            public String getRegistryhold() {
                return registryhold;
            }

            public void setRegistryhold(String registryhold) {
                this.registryhold = registryhold;
            }

            public String getEmailBindingStatus() {
                return emailBindingStatus;
            }

            public void setEmailBindingStatus(String emailBindingStatus) {
                this.emailBindingStatus = emailBindingStatus;
            }

            public String getPasswordHash() {
                return passwordHash;
            }

            public void setPasswordHash(String passwordHash) {
                this.passwordHash = passwordHash;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getAccountNumber() {
                return accountNumber;
            }

            public void setAccountNumber(String accountNumber) {
                this.accountNumber = accountNumber;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getBusinessLicense() {
                return businessLicense;
            }

            public void setBusinessLicense(int businessLicense) {
                this.businessLicense = businessLicense;
            }

            public int getCreditReport() {
                return creditReport;
            }

            public void setCreditReport(int creditReport) {
                this.creditReport = creditReport;
            }

            public int getIncome() {
                return income;
            }

            public void setIncome(int income) {
                this.income = income;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getLitpic() {
                return litpic;
            }

            public void setLitpic(String litpic) {
                this.litpic = litpic;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getCustomService() {
                return customService;
            }

            public void setCustomService(String customService) {
                this.customService = customService;
            }

            public String getIndustry() {
                return industry;
            }

            public void setIndustry(String industry) {
                this.industry = industry;
            }

            public String getCredit() {
                return credit;
            }

            public void setCredit(String credit) {
                this.credit = credit;
            }

            public String getAutoType() {
                return autoType;
            }

            public void setAutoType(String autoType) {
                this.autoType = autoType;
            }

            public String getLoginName() {
                return loginName;
            }

            public void setLoginName(String loginName) {
                this.loginName = loginName;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public int getIsTouzi() {
                return isTouzi;
            }

            public void setIsTouzi(int isTouzi) {
                this.isTouzi = isTouzi;
            }

            public String getSalesman() {
                return salesman;
            }

            public void setSalesman(String salesman) {
                this.salesman = salesman;
            }

            public int getMobileBindingStatus() {
                return mobileBindingStatus;
            }

            public void setMobileBindingStatus(int mobileBindingStatus) {
                this.mobileBindingStatus = mobileBindingStatus;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getInviteCode() {
                return inviteCode;
            }

            public void setInviteCode(String inviteCode) {
                this.inviteCode = inviteCode;
            }

            public int getLastLogintime() {
                return lastLogintime;
            }

            public void setLastLogintime(int lastLogintime) {
                this.lastLogintime = lastLogintime;
            }

            public int getRoom() {
                return room;
            }

            public void setRoom(int room) {
                this.room = room;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getScale() {
                return scale;
            }

            public void setScale(String scale) {
                this.scale = scale;
            }

            public String getTrustUsrCustId() {
                return trustUsrCustId;
            }

            public void setTrustUsrCustId(String trustUsrCustId) {
                this.trustUsrCustId = trustUsrCustId;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getBigPic() {
                return bigPic;
            }

            public void setBigPic(String bigPic) {
                this.bigPic = bigPic;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public int getIsRecharge() {
                return isRecharge;
            }

            public void setIsRecharge(int isRecharge) {
                this.isRecharge = isRecharge;
            }

            public int getRealVerifyStatus() {
                return realVerifyStatus;
            }

            public void setRealVerifyStatus(int realVerifyStatus) {
                this.realVerifyStatus = realVerifyStatus;
            }

            public int getAccountBook() {
                return accountBook;
            }

            public void setAccountBook(int accountBook) {
                this.accountBook = accountBook;
            }

            public int getMaritalStatus() {
                return maritalStatus;
            }

            public void setMaritalStatus(int maritalStatus) {
                this.maritalStatus = maritalStatus;
            }

            public String getEducation() {
                return education;
            }

            public void setEducation(String education) {
                this.education = education;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAnnualIncome() {
                return annualIncome;
            }

            public void setAnnualIncome(String annualIncome) {
                this.annualIncome = annualIncome;
            }

            public String getOrganization() {
                return organization;
            }

            public void setOrganization(String organization) {
                this.organization = organization;
            }

            public int getCollateral() {
                return collateral;
            }

            public void setCollateral(int collateral) {
                this.collateral = collateral;
            }

            public int getFieldCertification() {
                return fieldCertification;
            }

            public void setFieldCertification(int fieldCertification) {
                this.fieldCertification = fieldCertification;
            }

            public int getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(int createdAt) {
                this.createdAt = createdAt;
            }

            public String getOnPic() {
                return onPic;
            }

            public void setOnPic(String onPic) {
                this.onPic = onPic;
            }

            public String getIdCard() {
                return idCard;
            }

            public void setIdCard(String idCard) {
                this.idCard = idCard;
            }

            public String getMoneymoremoreId() {
                return moneymoremoreId;
            }

            public void setMoneymoremoreId(String moneymoremoreId) {
                this.moneymoremoreId = moneymoremoreId;
            }

            public int getVipGrade() {
                return vipGrade;
            }

            public void setVipGrade(int vipGrade) {
                this.vipGrade = vipGrade;
            }

            public String getInviteUserId() {
                return inviteUserId;
            }

            public void setInviteUserId(String inviteUserId) {
                this.inviteUserId = inviteUserId;
            }

            public String getWorkHours() {
                return workHours;
            }

            public void setWorkHours(String workHours) {
                this.workHours = workHours;
            }

            public String getCardIdBase() {
                return cardIdBase;
            }

            public void setCardIdBase(String cardIdBase) {
                this.cardIdBase = cardIdBase;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getPasswordPayHash() {
                return passwordPayHash;
            }

            public void setPasswordPayHash(String passwordPayHash) {
                this.passwordPayHash = passwordPayHash;
            }

            public String getCreatedIp() {
                return createdIp;
            }

            public void setCreatedIp(String createdIp) {
                this.createdIp = createdIp;
            }

            public String getLoginAccountId() {
                return loginAccountId;
            }

            public void setLoginAccountId(String loginAccountId) {
                this.loginAccountId = loginAccountId;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public String getCompanyCategory() {
                return companyCategory;
            }

            public void setCompanyCategory(String companyCategory) {
                this.companyCategory = companyCategory;
            }

            public int getBankAccount() {
                return bankAccount;
            }

            public void setBankAccount(int bankAccount) {
                this.bankAccount = bankAccount;
            }

            public int getDrivingLicense() {
                return drivingLicense;
            }

            public void setDrivingLicense(int drivingLicense) {
                this.drivingLicense = drivingLicense;
            }
        }
    }
}
