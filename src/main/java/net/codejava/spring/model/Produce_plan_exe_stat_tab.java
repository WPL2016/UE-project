package net.codejava.spring.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Produce_plan_exe_stat_tab {
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date exe_start_time;
	private String produce_plan_exe_stat_recorder_num;
	private String produce_plan_exe_stat_num;
	private String work_plan_num;
	
	
	public Produce_plan_exe_stat_tab() {
	}

	

	public @DateTimeFormat(pattern="yyyy-MM-dd") Date getExe_start_time() {
		return exe_start_time;
	}

	public void setExe_start_time(@DateTimeFormat(pattern="yyyy-MM-dd") Date exe_start_time) {
		this.exe_start_time = exe_start_time;
	}

	public String getProduce_plan_exe_stat_recorder_num() {
		return produce_plan_exe_stat_recorder_num;
	}

	public void setProduce_plan_exe_stat_recorder_num(String produce_plan_exe_stat_recorder_num) {
		this.produce_plan_exe_stat_recorder_num = produce_plan_exe_stat_recorder_num;
	}

	public String getProduce_plan_exe_stat_num() {
		return produce_plan_exe_stat_num;
	}

	public void setProduce_plan_exe_stat_num(String produce_plan_exe_stat_num) {
		this.produce_plan_exe_stat_num = produce_plan_exe_stat_num;
	}
	
	public String getWork_plan_num() {
		return work_plan_num;
	}

	public void setWork_plan_num(String work_plan_num) {
		this.work_plan_num = work_plan_num;
	}
}
	