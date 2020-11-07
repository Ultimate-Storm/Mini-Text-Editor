package backend;

/**
 * Class used for memento design pattern
 *
 *
 */
public class Memento {
	   private State state;

	   public Memento(State state){
	      this.state = state;
	   }

	   public State getState(){
	      return state;
	   }	
	}
