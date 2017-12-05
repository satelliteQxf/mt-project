import dkpro.similarity.algorithms.api.SimilarityException;
import dkpro.similarity.algorithms.api.TextSimilarityMeasure;
import dkpro.similarity.algorithms.lexical.ngrams.*;

public class FindSimilarity {

	public static void main(String[] args) throws SimilarityException {
		TextSimilarityMeasure measure = new WordNGramJaccardMeasure(3);

String[] tokens1 = "Have you see such a beautiful day .".split(" ");   
String[] tokens2 = "I have seen such a beautiful day .".split(" ");

double score = measure.getSimilarity(tokens1, tokens2);

System.out.println("Similarity: " + score);

	}

}
