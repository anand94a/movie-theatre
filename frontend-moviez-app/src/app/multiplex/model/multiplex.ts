export class Multiplex {
    multiplexId: String;
	multiplexName: String;
	city: String;
	numberOfScreens: number;
	setOfScreens: Set<any>;
	
    
    constructor(multiplexId?:String,multiplexName?:String,city?:String, numberOfScreens?:number, setOfScreens?: Set<any>){
		this.multiplexId = multiplexId;
		this.multiplexName = multiplexName;
		this.city = city;
		this.numberOfScreens = numberOfScreens;
		this.setOfScreens = setOfScreens;
	}
}
