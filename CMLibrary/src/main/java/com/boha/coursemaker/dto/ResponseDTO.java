/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.coursemaker.dto;

import com.boha.coursemaker.listeners.ResponseInterface;
import com.boha.coursemaker.util.CourseMakerData;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author aubreyM
 */
public class ResponseDTO implements Serializable, CourseMakerData,
		ResponseInterface {

	private static final long serialVersionUID = 1L;

	public static final int ERROR_UNKNOWN_REQUEST = 105;
	public static final int ERROR_INVALID_REQUEST = 100;
	public static final int ERROR_DATABASE = 120;
	public static final int ERROR_USER_LOGIN = 130;
	public static final int ERROR_DUPLICATE = 140;
	public static final int ERROR_SERVER = 150;
	public static final int ERROR_CALENDAR_NOT_FOUND = 160;
	public static final int ERROR_DATA_NOT_FOUND = 170;
	public static final int ERROR_FILE_DOWNLOAD = 180;
	public static final int ERROR_DELETE_NOT_POSSIBLE = 190;

	private int statusCode;
	private String message, GCMRegistrationID, sessionID;

	private CategoryDTO category;
	private AdministratorDTO administrator;
	private AuthorDTO author;
	private TraineeDTO trainee;
	private InstructorDTO instructor;
	private CompanyDTO company;
	private CourseDTO course;
	private CourseTraineeDTO courseTrainee;
	private CourseTraineeActivityDTO courseTraineeActivity;
	private TrainingClassDTO trainingClass;
	private HelpRequestDTO helpRequest;
	private HelpResponseDTO helpResponse;
	private ObjectiveDTO objective;
	private LessonResourceDTO lessonResource;
	private ActivityDTO activity;
	private EquipmentDTO equipment;
	private InventoryDTO inventory;
	private TraineeEquipmentDTO traineeEquipment;
	private DashboardTotalsDTO dashboardTotals;
	private TraineeRatingDTO traineeRating;
	private InstructorRatingDTO instructorRating;
	private TraineeShoutDTO traineeShout;
    private List<TraineeShoutDTO> traineeShoutList;
    private TrainingClassEventDTO trainingClassEvent;
    private List<TrainingClassEventDTO> trainingClassEventList;
    private TeamDTO team;
    private List<TeamDTO> teamList;
    private TeamMemberDTO teamMember;
    private List<TeamMemberDTO> teamMemberList;
    private List<ErrorStoreAndroidDTO> errorStoreAndroidList;
    
    private DemoAnnouncementDTO demoAnnouncement;
    private List<DemoAnnouncementDTO> demoAnnouncementList;
    private List<SkillDTO> skillList;
    private List<SkillLevelDTO> skillLevelList;
    private List<TraineeSkillDTO> traineeSkillList;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public List<SkillDTO> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<SkillDTO> skillList) {
        this.skillList = skillList;
    }

    public List<SkillLevelDTO> getSkillLevelList() {
        return skillLevelList;
    }

    public void setSkillLevelList(List<SkillLevelDTO> skillLevelList) {
        this.skillLevelList = skillLevelList;
    }

    public List<TraineeSkillDTO> getTraineeSkillList() {
        return traineeSkillList;
    }

    public void setTraineeSkillList(List<TraineeSkillDTO> traineeSkillList) {
        this.traineeSkillList = traineeSkillList;
    }

    public List<ErrorStoreAndroidDTO> getErrorStoreAndroidList() {
        return errorStoreAndroidList;
    }

    public void setErrorStoreAndroidList(List<ErrorStoreAndroidDTO> errorStoreAndroidList) {
        this.errorStoreAndroidList = errorStoreAndroidList;
    }

    public TraineeShoutDTO getTraineeShout() {
		return traineeShout;
	}

	public void setTraineeShout(TraineeShoutDTO traineeShout) {
		this.traineeShout = traineeShout;
	}

	public List<TraineeShoutDTO> getTraineeShoutList() {
		return traineeShoutList;
	}

	public void setTraineeShoutList(List<TraineeShoutDTO> traineeShoutList) {
		this.traineeShoutList = traineeShoutList;
	}

	//
	private List<ErrorStoreDTO> errorStoreList;

	public List<ErrorStoreDTO> getErrorStoreList() {
		return errorStoreList;
	}

	public void setErrorStoreList(List<ErrorStoreDTO> errorStoreList) {
		this.errorStoreList = errorStoreList;
	}

	private List<HelpResponseDTO> helpResponseList;
	private List<HelpRequestDTO> helpRequestList;
	private List<HelpTypeDTO> helpTypeList;
	private List<ObjectiveDTO> objectiveList;
	private List<ActivityDTO> activityList;
	private List<TraineeDTO> traineeList;
	private List<CategoryDTO> categoryList;
	private List<CountryDTO> countryList;
	private List<CourseTraineeDTO> courseTraineeList;
	private List<InstitutionDTO> institutionList;
	private List<EquipmentDTO> equipmentList;
	private List<TraineeEquipmentDTO> traineeEquipmentList;
	private List<InstructorRatingDTO> instructorRatingList;
	private List<TraineeRatingDTO> traineeRatingList;
	private List<LessonResourceDTO> lessonResourceList;
	private List<TrainingClassCourseDTO> trainingClassCourseList;
	private List<InstructorDTO> instructorList;
	private List<CourseTraineeActivityDTO> courseTraineeActivityList;
	private List<CourseDTO> courseList;
	private List<RatingDTO> ratingList;
	private List<InventoryDTO> inventoryList;
	private List<TrainingClassDTO> trainingClassList;
	private List<TotalsDTO> totals;
	private List<GcmDeviceDTO> gcmDeviceList;
	private List<CalendarDTO> calendarList;
	private List<AdministratorDTO> administratorList;
	private List<ProvinceDTO> provinceList;
	private List<AuthorDTO> authorList;
	List<InstructorClassDTO> instructorClassList;
	private String credential;

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	int totalCourses;

	public List<LessonResourceDTO> getLessonResourceList() {
		return lessonResourceList;
	}

	public void setLessonResourceList(List<LessonResourceDTO> lessonResourceList) {
		this.lessonResourceList = lessonResourceList;
	}

	public List<TrainingClassDTO> getTrainingClassList() {
		return trainingClassList;
	}

	public void setTrainingClassList(List<TrainingClassDTO> trainingClassList) {
		this.trainingClassList = trainingClassList;
	}

	public AdministratorDTO getAdministrator() {
		return administrator;
	}

	public void setAdministrator(AdministratorDTO administrator) {
		this.administrator = administrator;
	}

	public HelpRequestDTO getHelpRequest() {
		return helpRequest;
	}

	public List<InventoryDTO> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<InventoryDTO> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public void setHelpRequest(HelpRequestDTO helpRequest) {
		this.helpRequest = helpRequest;
	}

	public List<RatingDTO> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<RatingDTO> ratingList) {
		this.ratingList = ratingList;
	}

	public List<HelpRequestDTO> getHelpRequestList() {
		return helpRequestList;
	}

	public void setHelpRequestList(List<HelpRequestDTO> helpRequestList) {
		this.helpRequestList = helpRequestList;
	}

	public List<HelpTypeDTO> getHelpTypeList() {
		return helpTypeList;
	}

	public void setHelpTypeList(List<HelpTypeDTO> helpTypeList) {
		this.helpTypeList = helpTypeList;
	}

	//

	public List<CourseTraineeActivityDTO> getCourseTraineeActivityList() {
		return courseTraineeActivityList;
	}

	public void setCourseTraineeActivityList(
			List<CourseTraineeActivityDTO> courseTraineeActivityList) {
		this.courseTraineeActivityList = courseTraineeActivityList;
	}

	public TrainingClassDTO getTrainingClass() {
		return trainingClass;
	}

	public void setTrainingClass(TrainingClassDTO trainingClass) {
		this.trainingClass = trainingClass;
	}

	public CourseTraineeActivityDTO getCourseTraineeActivity() {
		return courseTraineeActivity;
	}

	public void setCourseTraineeActivity(
			CourseTraineeActivityDTO courseTraineeActivity) {
		this.courseTraineeActivity = courseTraineeActivity;
	}


	public TraineeDTO getTrainee() {
		return trainee;
	}

	public List<TrainingClassCourseDTO> getTrainingClassCourseList() {
		return trainingClassCourseList;
	}

	public void setTrainingClassCourseList(
			List<TrainingClassCourseDTO> trainingClassCourseList) {
		this.trainingClassCourseList = trainingClassCourseList;
	}

	public CourseTraineeDTO getCourseTrainee() {
		return courseTrainee;
	}

	public void setCourseTrainee(CourseTraineeDTO courseTrainee) {
		this.courseTrainee = courseTrainee;
	}

	public void setTrainee(TraineeDTO trainee) {
		this.trainee = trainee;
	}

	public List<InstructorDTO> getInstructorList() {
		return instructorList;
	}

	public void setInstructorList(List<InstructorDTO> instructorList) {
		this.instructorList = instructorList;
	}


	public List<ActivityDTO> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<ActivityDTO> activityList) {
		this.activityList = activityList;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public InstructorDTO getInstructor() {
		return instructor;
	}

	public void setInstructor(InstructorDTO instructor) {
		this.instructor = instructor;
	}

	public List<TraineeDTO> getTraineeList() {
		return traineeList;
	}

	public void setTraineeList(List<TraineeDTO> traineeList) {
		this.traineeList = traineeList;
	}

	public List<CategoryDTO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}

	public List<CountryDTO> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CountryDTO> countryList) {
		this.countryList = countryList;
	}

	public List<CourseTraineeDTO> getCourseTraineeList() {
		return courseTraineeList;
	}

	public void setCourseTraineeList(List<CourseTraineeDTO> courseTraineeList) {
		this.courseTraineeList = courseTraineeList;
	}

	public List<InstitutionDTO> getInstitutionList() {
		return institutionList;
	}

	public void setInstitutionList(List<InstitutionDTO> institutionList) {
		this.institutionList = institutionList;
	}

	public List<EquipmentDTO> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<EquipmentDTO> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public List<TraineeEquipmentDTO> getTraineeEquipmentList() {
		return traineeEquipmentList;
	}

	public void setTraineeEquipmentList(
			List<TraineeEquipmentDTO> traineeEquipmentList) {
		this.traineeEquipmentList = traineeEquipmentList;
	}

	public List<InstructorRatingDTO> getInstructorRatingList() {
		return instructorRatingList;
	}

	public void setInstructorRatingList(
			List<InstructorRatingDTO> instructorRatingList) {
		this.instructorRatingList = instructorRatingList;
	}

	public List<TraineeRatingDTO> getTraineeRatingList() {
		return traineeRatingList;
	}

	public void setTraineeRatingList(List<TraineeRatingDTO> traineeRatingList) {
		this.traineeRatingList = traineeRatingList;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}

	public List<CourseDTO> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseDTO> courseList) {
		this.courseList = courseList;
	}

		public ObjectiveDTO getObjective() {
		return objective;
	}

	public void setObjective(ObjectiveDTO objective) {
		this.objective = objective;
	}

	public List<ObjectiveDTO> getObjectiveList() {
		return objectiveList;
	}

	public void setObjectiveList(List<ObjectiveDTO> objectiveList) {
		this.objectiveList = objectiveList;
	}

	public LessonResourceDTO getLessonResource() {
		return lessonResource;
	}

	public void setLessonResource(LessonResourceDTO lessonResource) {
		this.lessonResource = lessonResource;
	}

	public ActivityDTO getActivity() {
		return activity;
	}

	public void setActivity(ActivityDTO activity) {
		this.activity = activity;
	}

	public List<TotalsDTO> getTotals() {
		return totals;
	}

	public void setTotals(List<TotalsDTO> totals) {
		this.totals = totals;
	}

	public String getGCMRegistrationID() {
		return GCMRegistrationID;
	}

	public void setGCMRegistrationID(String gCMRegistrationID) {
		GCMRegistrationID = gCMRegistrationID;
	}

	public List<GcmDeviceDTO> getGcmDeviceList() {
		return gcmDeviceList;
	}

	public void setGcmDeviceList(List<GcmDeviceDTO> gcmDeviceList) {
		this.gcmDeviceList = gcmDeviceList;
	}

	public List<HelpResponseDTO> getHelpResponseList() {
		return helpResponseList;
	}

	public void setHelpResponseList(List<HelpResponseDTO> helpResponseList) {
		this.helpResponseList = helpResponseList;
	}

	public HelpResponseDTO getHelpResponse() {
		return helpResponse;
	}

	public void setHelpResponse(HelpResponseDTO helpResponse) {
		this.helpResponse = helpResponse;
	}

	
	public List<CalendarDTO> getCalendarList() {
		return calendarList;
	}

	public void setCalendarList(List<CalendarDTO> calendarList) {
		this.calendarList = calendarList;
	}

	

	public List<AdministratorDTO> getAdministratorList() {
		return administratorList;
	}

	public void setAdministratorList(List<AdministratorDTO> administratorList) {
		this.administratorList = administratorList;
	}

	public List<ProvinceDTO> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<ProvinceDTO> provinceList) {
		this.provinceList = provinceList;
	}

	public List<AuthorDTO> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<AuthorDTO> authorList) {
		this.authorList = authorList;
	}

	public EquipmentDTO getEquipment() {
		return equipment;
	}

	public void setEquipment(EquipmentDTO equipment) {
		this.equipment = equipment;
	}

	public InventoryDTO getInventory() {
		return inventory;
	}

	public void setInventory(InventoryDTO inventory) {
		this.inventory = inventory;
	}

	public TraineeEquipmentDTO getTraineeEquipment() {
		return traineeEquipment;
	}

	public void setTraineeEquipment(TraineeEquipmentDTO traineeEquipment) {
		this.traineeEquipment = traineeEquipment;
	}

	public List<InstructorClassDTO> getInstructorClassList() {
		return instructorClassList;
	}

	public void setInstructorClassList(
			List<InstructorClassDTO> instructorClassList) {
		this.instructorClassList = instructorClassList;
	}

	public DashboardTotalsDTO getDashboardTotals() {
		return dashboardTotals;
	}

	public void setDashboardTotals(DashboardTotalsDTO dashboardTotals) {
		this.dashboardTotals = dashboardTotals;
	}

	public int getTotalCourses() {
		return totalCourses;
	}

	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}

	public TraineeRatingDTO getTraineeRating() {
		return traineeRating;
	}

	public void setTraineeRating(TraineeRatingDTO traineeRating) {
		this.traineeRating = traineeRating;
	}

	public InstructorRatingDTO getInstructorRating() {
		return instructorRating;
	}

	public void setInstructorRating(InstructorRatingDTO instructorRating) {
		this.instructorRating = instructorRating;
	}

	public TrainingClassEventDTO getTrainingClassEvent() {
		return trainingClassEvent;
	}

	public void setTrainingClassEvent(TrainingClassEventDTO trainingClassEvent) {
		this.trainingClassEvent = trainingClassEvent;
	}

	public List<TrainingClassEventDTO> getTrainingClassEventList() {
		return trainingClassEventList;
	}

	public void setTrainingClassEventList(
			List<TrainingClassEventDTO> trainingClassEventList) {
		this.trainingClassEventList = trainingClassEventList;
	}

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}

	public List<TeamDTO> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<TeamDTO> teamList) {
		this.teamList = teamList;
	}

	public TeamMemberDTO getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(TeamMemberDTO teamMember) {
		this.teamMember = teamMember;
	}

	public List<TeamMemberDTO> getTeamMemberList() {
		return teamMemberList;
	}

	public void setTeamMemberList(List<TeamMemberDTO> teamMemberList) {
		this.teamMemberList = teamMemberList;
	}

	public DemoAnnouncementDTO getDemoAnnouncement() {
		return demoAnnouncement;
	}

	public void setDemoAnnouncement(DemoAnnouncementDTO demoAnnouncement) {
		this.demoAnnouncement = demoAnnouncement;
	}

	public List<DemoAnnouncementDTO> getDemoAnnouncementList() {
		return demoAnnouncementList;
	}

	public void setDemoAnnouncementList(
			List<DemoAnnouncementDTO> demoAnnouncementList) {
		this.demoAnnouncementList = demoAnnouncementList;
	}

}
