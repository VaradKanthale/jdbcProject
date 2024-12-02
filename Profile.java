package jdbc;

public class Profile {
	    int profileId;
	     String subject;
	 	int password;
	 	int id;
	 	
	 	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getProfileId() {
			return profileId;
		}
		public void setProfileId(int profileId) {
			this.profileId = profileId;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public int getPassword() {
			return password;
		}
		public void setPassword(int password) {
			this.password = password;
		}
		
		public Profile(int profileId, String subject, int password, int id) {
			super();
			this.profileId = profileId;
			this.subject = subject;
			this.password = password;
			this.id = id;
		}
		public Profile() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Profile [profileId=" + profileId + ", subject=" + subject + ", password=" + password + ", id=" + id
					+ "]";
		}
	 	
	 	
}
