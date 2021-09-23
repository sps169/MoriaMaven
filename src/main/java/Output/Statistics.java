package Output;

import Execution.Run;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Statistics {
	private Set<Run> runsSample;
	private int runsRoomNumber = 36;
	private int successfulRuns;
	private int nonSuccessfulRuns;
	private int roomsConquered;
	private int roomsFled;
	private int aliveMages;
	private int aliveArchers;
	private int aliveRingUsers;
	private float meanSuccessfulRuns;
	private float meanAliveMages;
	private float meanAliveArchers;
	private float meanAliveRingUsers;
	private float meanRoomNumberRingDead;
	private float meanRoomNumberMageDead;
	private float meanRoomNumberArcherDead;
	private float meanConqueredRooms;
	private float meanFledRooms;

	public int getRunsRoomNumber() {
		return runsRoomNumber;
	}

	public void setRunsRoomNumber(int runsRoomNumber) {
		this.runsRoomNumber = runsRoomNumber;
	}

	public Set<Run> getRunsSample() {
		return runsSample;
	}

	public void setRunsSample(Set<Run> runsSample) {
		this.runsSample = runsSample;
	}

	public int getSuccessfulRuns() {
		return successfulRuns;
	}

	public void setSuccessfulRuns(int successfulRuns) {
		this.successfulRuns = successfulRuns;
	}

	public int getNonSuccessfulRuns() {
		return nonSuccessfulRuns;
	}

	public void setNonSuccessfulRuns(int nonSuccessfulRuns) {
		this.nonSuccessfulRuns = nonSuccessfulRuns;
	}

	public int getRoomsConquered() {
		return roomsConquered;
	}

	public void setRoomsConquered(int roomsConquered) {
		this.roomsConquered = roomsConquered;
	}

	public int getRoomsFled() {
		return roomsFled;
	}

	public void setRoomsFled(int roomsFled) {
		this.roomsFled = roomsFled;
	}

	public int getAliveMages() {
		return aliveMages;
	}

	public void setAliveMages(int aliveMages) {
		this.aliveMages = aliveMages;
	}

	public int getAliveArchers() {
		return aliveArchers;
	}

	public void setAliveArchers(int aliveArchers) {
		this.aliveArchers = aliveArchers;
	}

	public int getAliveRingUsers() {
		return aliveRingUsers;
	}

	public void setAliveRingUsers(int aliveRingUsers) {
		this.aliveRingUsers = aliveRingUsers;
	}

	public float getMeanSuccessfulRuns() {
		return meanSuccessfulRuns;
	}

	public void setMeanSuccessfulRuns(float meanSuccessfulRuns) {
		this.meanSuccessfulRuns = meanSuccessfulRuns;
	}

	public float getMeanAliveMages() {
		return meanAliveMages;
	}

	public void setMeanAliveMages(float meanAliveMages) {
		this.meanAliveMages = meanAliveMages;
	}

	public float getMeanAliveArchers() {
		return meanAliveArchers;
	}

	public void setMeanAliveArchers(float meanAliveArchers) {
		this.meanAliveArchers = meanAliveArchers;
	}

	public float getMeanAliveRingUsers() {
		return meanAliveRingUsers;
	}

	public void setMeanAliveRingUsers(float meanAliveRingUsers) {
		this.meanAliveRingUsers = meanAliveRingUsers;
	}

	public float getMeanRoomNumberRingDead() {
		return meanRoomNumberRingDead;
	}

	public void setMeanRoomNumberRingDead(float meanRoomNumberRingDead) {
		this.meanRoomNumberRingDead = meanRoomNumberRingDead;
	}

	public float getMeanRoomNumberMageDead() {
		return meanRoomNumberMageDead;
	}

	public void setMeanRoomNumberMageDead(float meanRoomNumberMageDead) {
		this.meanRoomNumberMageDead = meanRoomNumberMageDead;
	}

	public float getMeanRoomNumberArcherDead() {
		return meanRoomNumberArcherDead;
	}

	public void setMeanRoomNumberArcherDead(float meanRoomNumberArcherDead) {
		this.meanRoomNumberArcherDead = meanRoomNumberArcherDead;
	}

	public float getMeanConqueredRooms() {
		return meanConqueredRooms;
	}

	public void setMeanConqueredRooms(float meanConqueredRooms) {
		this.meanConqueredRooms = meanConqueredRooms;
	}

	public float getMeanFledRooms() {
		return meanFledRooms;
	}

	public void setMeanFledRooms(float meanFledRooms) {
		this.meanFledRooms = meanFledRooms;
	}

	public Statistics ()
	{
		runsSample = new HashSet<>();
	}

	public boolean addRunToSample(Run run)
	{
		boolean wasAdded = false;
		if (!this.runsSample.contains(run))
			wasAdded = this.runsSample.add(run);
		return wasAdded;
	}

	public int addRunCollectionToSample(Collection<Run> collection)
	{
		int nUniqueRuns = 0;
		if (collection != null)
		{
			for (Run run:collection) {
				this.addRunToSample(run);
				nUniqueRuns++;
			}
		}
		return nUniqueRuns;
	}

	private void getRunsResults()
	{
		for (Run run:this.runsSample) {
			if (run.getResult())
				this.successfulRuns++;
			else
				this.nonSuccessfulRuns++;
			this.roomsConquered += run.getConqueredRooms();
			this.roomsFled += run.getFledRooms();
		}
		this.meanConqueredRooms = ((float)this.roomsConquered / ((float)this.runsSample.size()*(float)this.runsRoomNumber));
		this.meanFledRooms = ((float)this.roomsFled / ((float)this.runsSample.size()*(float)this.runsRoomNumber));
		this.meanSuccessfulRuns = (float)this.successfulRuns / (float)this.runsSample.size();
	}

	private void getDeathsData()
	{
		int sumRoomsArchers = 0;
		int sumRoomsMages = 0;
		int sumRoomsRings = 0;

		for (Run run:this.runsSample) {
			if (run.getRoomWhereQuiverUserDies() == -1 && run.getResult())
				this.aliveArchers++;
			else
				sumRoomsArchers += run.getRoomWhereQuiverUserDies();
			if (run.getRoomWhereStaffUserDies() == -1 && run.getResult())
				this.aliveMages++;
			else
				sumRoomsMages += run.getRoomWhereStaffUserDies();
			if (run.getRoomWhereRingUserDies() == -1 && run.getResult())
				this.aliveRingUsers++;
			else
				sumRoomsRings += run.getRoomWhereRingUserDies();
		}
		this.meanRoomNumberArcherDead = (float)sumRoomsArchers / (float)this.nonSuccessfulRuns;
		this.meanRoomNumberMageDead = (float)sumRoomsMages / (float)this.nonSuccessfulRuns;
		this.meanRoomNumberRingDead = (float)sumRoomsRings / (float)this.nonSuccessfulRuns;
		this.meanAliveArchers = (float)this.aliveArchers / (float)this.successfulRuns;
		this.meanAliveMages = (float)this.aliveMages / (float)this.successfulRuns;
		this.meanAliveRingUsers =  (float)this.aliveRingUsers / (float)this.successfulRuns;
	}

	public Statistics generateStatistics()
	{
		this.getRunsResults();
		this.getDeathsData();
		return this;
	}


}
