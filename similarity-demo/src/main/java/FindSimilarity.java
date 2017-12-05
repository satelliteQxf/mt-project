import dkpro.similarity.algorithms.api.SimilarityException;
import dkpro.similarity.algorithms.api.TextSimilarityMeasure;
import dkpro.similarity.algorithms.lexical.ngrams.*;
import dkpro.similarity.algorithms.lexical.string.GreedyStringTiling;
import dkpro.similarity.algorithms.vsm.ExplicitSemanticAnalysisComparator;
public class FindSimilarity{

	public double similarityScore(String origin, String translate) throws SimilarityException {
		TextSimilarityMeasure measure = new GreedyStringTiling(1);
		//TextSimilarityMeasure measure = new WordNGramJaccardMeasure(3);

		String[] tokens1 = origin.split(" ");
		String[] tokens2 = translate.split(" ");

		double score = measure.getSimilarity(tokens1, tokens2);

		return score;

	}


}
