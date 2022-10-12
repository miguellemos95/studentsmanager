import { SortAlgorithm } from "./sortalgorithm";
import { Student } from "./student";

export interface SortStudentsRequest{
  selectedAlgorithm: SortAlgorithm;
  students: Student[];
}
