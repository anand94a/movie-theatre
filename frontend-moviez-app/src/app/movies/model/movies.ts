export class Movies {
    movieId: String;
	movieName: String;
	movieCategory: String;
	producer: String;
	director: String;
    releaseDate: String;
    
    constructor(movieName?:String,movieCategory?:String,producer?:String,director?:String, releaseDate?:string){
		this.movieName = movieName;
		this.movieCategory = movieCategory;
		this.producer = producer;
		this.director = director;
		this.releaseDate = releaseDate;
	}
}
