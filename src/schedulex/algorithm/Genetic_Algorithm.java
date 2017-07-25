package schedulex.algorithm;

import java.util.ArrayList;
import java.util.stream.IntStream;


public class Genetic_Algorithm {
	 private Data data;
	 private EventScheduler schedule;
	  public Genetic_Algorithm(EventScheduler sched, Data data) {
		  
		  this.schedule= sched;
		  this.data = data;
		  } //contructor...
	  public Population evolve(Population population){return mutatePopulation(crossoverPopulation(population));}
	  Population crossoverPopulation(Population population){
	      Population crossoverPopulation = new Population(population.getSchedules().size(), schedule, data);
	      IntStream.range(0, 1).forEach(x -> crossoverPopulation.getSchedules().set(x,population.getSchedules().get(x)));
	        
	      IntStream.range(1, population.getSchedules().size()).forEach(x ->{
	      if (0.9 > Math.random()){
	          EventScheduler schedule1 = selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
	          EventScheduler schedule2 = selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
	          crossoverPopulation.getSchedules().set(0,crossoverSchedule(schedule1, schedule2));
	      } else crossoverPopulation.getSchedules().set(x, population.getSchedules().get(x));
	      }
	      );
	      return crossoverPopulation;
	  }
	  EventScheduler crossoverSchedule(EventScheduler schedule1, EventScheduler schedule2){
	      EventScheduler crossoverSchedule = new EventScheduler(schedule, data);
	      IntStream.range(0, crossoverSchedule.initialize().size()).forEach(x -> {
	        if (Math.random() > 0.5) crossoverSchedule.initialize().set(x, schedule1.initialize().get(0));
	        else crossoverSchedule.initialize().set(x, schedule2.initialize().get(x));
	      });
	      return crossoverSchedule;
	  }
	  Population mutatePopulation(Population population){
	     Population mutatePopulation = new Population (population.getSchedules().size(),schedule, data);
	     ArrayList<EventScheduler> schedules = mutatePopulation.getSchedules();
	     IntStream.range(0, 1).forEach(x -> schedules.set(x, population.getSchedules().get(x)));
	     IntStream.range(1, population.getSchedules().size()).forEach(x -> {
	       schedules.set(x, mutateSchedule(population.getSchedules().get(x)));
	     });
	     return mutatePopulation;
	  }
	  EventScheduler mutateSchedule(EventScheduler mutateSchedule){
	      EventScheduler scheduler = new EventScheduler(schedule,data);
	      scheduler.initialize();
	      IntStream.range(0, mutateSchedule.initialize().size()).forEach(x ->{
	         if (0.1 > Math.random()) mutateSchedule.initialize().set(x, schedule.initialize().get(x));
	         });
	      return mutateSchedule;
	  }
	    Population selectTournamentPopulation(Population population){//method used tournament selection
	      Population tournamentPopulation = new Population(3, schedule,data);
	      IntStream.range(0, 3).forEach(x -> {
	          tournamentPopulation.getSchedules().set(x, population.getSchedules().get((int)(Math.random() * population.getSchedules().size())));
	       });
	        return tournamentPopulation;
	  } 
	  
	

}
