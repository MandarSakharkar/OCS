export class Preference {

    private preferenceId:Number;	
	private preferenceNumber:Number;	
	private instituteCourse;
    private formNumber:Number;

    getPreferenceId()
    {
        return this.preferenceId;
    }

    setPreferenceId(preferenceId:Number)
    {
        this.preferenceId=preferenceId;
    }

    getFormNumber()
    {
        return this.formNumber;
    }

    setFormNumber(formNumber:Number)
    {
        this.formNumber=formNumber;
    }

    getInstituteCourse()
    {
        return this.instituteCourse;
    }

    setInstituteCourse(instituteCourse)
    {
        this.instituteCourse=instituteCourse;
    }
    
    
    setPreferenceNumber(preferenceNumber:Number)
    {
        this.preferenceNumber=preferenceNumber;
    }
    getPreferenceNumber()
    {
        return this.preferenceNumber;
    }
    
    constructor(preferenceId:Number,instituteCourse,preferenceNumber:Number,formNumber:Number) 
    {
        this.formNumber=formNumber;
        this.preferenceId=preferenceId;
        this.preferenceNumber=preferenceNumber;
        this.instituteCourse=instituteCourse;
    }
}