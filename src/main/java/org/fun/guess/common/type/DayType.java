package org.fun.guess.common.type;

public enum DayType implements EnumCodeBase,EnumNameBase {

	MONDAY("monday", "星期一");

	private String code;
	private String name;

	private DayType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toName() {
		return this.name;
	}

	@Override
	public String toCode() {
		return this.code;
	}

}
