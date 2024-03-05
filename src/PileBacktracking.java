package solver;

import java.util.Stack;

/**
 * Class PileBacktracking is use in the solver to keep
 * the progression in the solving process
 *
 * @author Charles T.
 * @version 1.0
 */

public class PileBacktracking {

    private Stack stackBacktracking;

    /**
     * Initialisation of the Pile.
     *
     */
    public PileBacktracking(){
        this.stackBacktracking = new Stack<>();
    }

    /**
     * Method pushPile add an object on top of the pile.
     * It is only use by the solver to keep the progression.
     *
     * @param objects the object created in the solver
     */
    public void pushPile(Object objects){
        this.stackBacktracking.push(objects);
    }

    /**
     * Method pullPile remove the object on top of the pile.
     * It is only use by the solver to keep the progression.
     *
     */
    public void pullPile(){
        this.stackBacktracking.pop();
    }

    /**
     * Method getTopPile give the object on top of the Pile.
     * It is only use by the solver to keep the progression.
     *
     * @return  the objects on top of the Pile
     */
    public Object getTopPile(){
        return this.stackBacktracking.peek();
    }

    /**
     * Method getSizePile give the size of the Pile.
     * It is only use by the solver to keep the progression.
     *
     * @return  the size of the Pile
     */
    public int getSizePile(){
        return this.stackBacktracking.size();
    }

    /**
     * Method isPileEmpty give the information if the Pile is empty.
     * It is only use by the solver to keep the progression.
     *
     * @return  the boolean to know if the Pile is empty
     */
    public boolean isPileEmpty(){
        return this.stackBacktracking.isEmpty();
    }
}
