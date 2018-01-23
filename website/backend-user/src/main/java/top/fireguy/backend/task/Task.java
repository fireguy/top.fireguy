package top.fireguy.backend.task;

import java.util.Date;

public class Task {
	/**
	 * 任务标题
	 */
	private String title = "";
	/**
	 * 任务描述
	 */
	private String description = "";
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date stopTime;
	/**
	 * 截止时间
	 */
	private Date deadline;
	/**
	 * 任务分类
	 */
	private String category = "";
	/**
	 * 是否重复
	 */
	private boolean isRepeat = false;
	/**
	 * 重复规则
	 */
	private String[] repeatRule = {};
	/**
	 * 是否提醒
	 */
	private boolean isRemind = false;
	/**
	 * 第一次提醒时间
	 */
	private Date remindFirstTime;
	
	/**
	 * 第二次提醒时间
	 */
	private Date remindSecondTime;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the stopTime
	 */
	public Date getStopTime() {
		return stopTime;
	}

	/**
	 * @param stopTime the stopTime to set
	 */
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * @return the deadline
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the isRepeat
	 */
	public boolean isRepeat() {
		return isRepeat;
	}

	/**
	 * @param isRepeat the isRepeat to set
	 */
	public void setRepeat(boolean isRepeat) {
		this.isRepeat = isRepeat;
	}

	/**
	 * @return the repeatRule
	 */
	public String[] getRepeatRule() {
		return repeatRule;
	}

	/**
	 * @param repeatRule the repeatRule to set
	 */
	public void setRepeatRule(String[] repeatRule) {
		this.repeatRule = repeatRule;
	}

	/**
	 * @return the isRemind
	 */
	public boolean isRemind() {
		return isRemind;
	}

	/**
	 * @param isRemind the isRemind to set
	 */
	public void setRemind(boolean isRemind) {
		this.isRemind = isRemind;
	}

	/**
	 * @return the remindFirstTime
	 */
	public Date getRemindFirstTime() {
		return remindFirstTime;
	}

	/**
	 * @param remindFirstTime the remindFirstTime to set
	 */
	public void setRemindFirstTime(Date remindFirstTime) {
		this.remindFirstTime = remindFirstTime;
	}

	/**
	 * @return the remindSecondTime
	 */
	public Date getRemindSecondTime() {
		return remindSecondTime;
	}

	/**
	 * @param remindSecondTime the remindSecondTime to set
	 */
	public void setRemindSecondTime(Date remindSecondTime) {
		this.remindSecondTime = remindSecondTime;
	}
	
}
