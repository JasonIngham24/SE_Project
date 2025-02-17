package project.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ConceptualAPIPrototype {
  // Marker annotation, should be applied to a method within a prototype class
	
	//retrieve data from input processor
	//public void processInputData() {
	//initialize data
	//read in file using delimiter
	//set the final destination
}
