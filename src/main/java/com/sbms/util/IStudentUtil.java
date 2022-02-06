package com.sbms.util;

import com.sbms.model.Student;

public interface IStudentUtil {

	// #.Java 8 feature static method
	public static void calculateDtls(Student s) {
		// calculations
		// JDK 10-LocalVariable Type Inference
		var fee = s.getStdFee();
		var disc = fee * 10 / 100.0;
		var gst = fee * 12 / 100.0;

		// set it back to same object
		s.setStdFeeDisc(disc);
		s.setStdFeeGst(gst);
	}

}
