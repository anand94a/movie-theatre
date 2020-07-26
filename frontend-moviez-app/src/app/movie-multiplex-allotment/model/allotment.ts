export class Allotment {
    allotmentId: String;
    movieName: String;
    multiplexName: String;
    location: String;
    city: String;
    screenNumber: Number;

    constructor(allotmentId?: String,
        movieName?: String,
        multiplexName?: String,
        location?: String,
        city?: String,
        screenNumber?: Number) {
            
        this.allotmentId = allotmentId;
        this.movieName = movieName;
        this.multiplexName = multiplexName;
        this.location = location;
        this.city = city;
        this.screenNumber = screenNumber

    }
}
