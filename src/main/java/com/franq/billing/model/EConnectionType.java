package com.franq.billing.model;

public enum EConnectionType {

	SMS(0),
	PHONECALL(1),
	//Nienzany
	UNKNOWN(99);

	private final int value;

	private EConnectionType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	 
    public static EConnectionType createEnum(int value){
        for (EConnectionType s : EConnectionType.values()){
            if (value == s.value)
                return s;
        }
        return UNKNOWN;
    }    

	
	
	
}
