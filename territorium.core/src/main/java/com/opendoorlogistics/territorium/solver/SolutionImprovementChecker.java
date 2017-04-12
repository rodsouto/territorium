package com.opendoorlogistics.territorium.solver;

import com.opendoorlogistics.territorium.solver.data.Cost;

public class SolutionImprovementChecker {
	private final ImmutableSolution refSolution;
	public SolutionImprovementChecker(ImmutableSolution solution){
		// take deep copy
		refSolution = new MutableSolution(solution);
	}
	
	/**
	 * 
	 * @param newSolution
	 * @return True if new solution is definitely better
	 */
	public boolean isImproved(ImmutableSolution newSolution){
		// see if we've improved by more than the round-off limit
		Cost newCost = newSolution.getCost();
		if (!Cost.isApproxEqual(refSolution.getCost(), newCost)) {
			return newCost.compareTo(refSolution.getCost()) < 0;
		}
		return false;
		
	}
	
	public Cost getReferenceCost(){
		return refSolution.getCost();
	}
}