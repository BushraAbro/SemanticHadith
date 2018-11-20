package HadithRDFconvertor.impl;

import HadithRDFconvertor.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultHadithChapter <br>
 * @version generated on Mon Aug 08 23:13:15 PKT 2016 by Bushra
 */
public class DefaultHadithChapter extends WrappedIndividualImpl implements HadithChapter {

    public DefaultHadithChapter(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://purl.org/dc/terms/hasPart
     */
     
    public Collection<? extends WrappedIndividual> getHasPart() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASPART,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHasPart() {
	   return !getHasPart().isEmpty();
    }

    public void addHasPart(WrappedIndividual newHasPart) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASPART,
                                       newHasPart);
    }

    public void removeHasPart(WrappedIndividual oldHasPart) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASPART,
                                          oldHasPart);
    }


    /* ***************************************************
     * Object Property http://purl.org/dc/terms/isPartOf
     */
     
    public Collection<? extends WrappedIndividual> getIsPartOf() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ISPARTOF,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasIsPartOf() {
	   return !getIsPartOf().isEmpty();
    }

    public void addIsPartOf(WrappedIndividual newIsPartOf) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ISPARTOF,
                                       newIsPartOf);
    }

    public void removeIsPartOf(WrappedIndividual oldIsPartOf) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ISPARTOF,
                                          oldIsPartOf);
    }


    /* ***************************************************
     * Object Property http://quranontology.com/Resource/MentionedIn
     */
     
    public Collection<? extends Hadith> getMentionedIn() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_MENTIONEDIN,
                                               DefaultHadith.class);
    }

    public boolean hasMentionedIn() {
	   return !getMentionedIn().isEmpty();
    }

    public void addMentionedIn(Hadith newMentionedIn) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_MENTIONEDIN,
                                       newMentionedIn);
    }

    public void removeMentionedIn(Hadith oldMentionedIn) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_MENTIONEDIN,
                                          oldMentionedIn);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#collectionName
     */
     
    public Collection<? extends Object> getCollectionName() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_COLLECTIONNAME, Object.class);
    }

    public boolean hasCollectionName() {
		return !getCollectionName().isEmpty();
    }

    public void addCollectionName(Object newCollectionName) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_COLLECTIONNAME, newCollectionName);
    }

    public void removeCollectionName(Object oldCollectionName) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_COLLECTIONNAME, oldCollectionName);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#deprecatedBookNo
     */
     
    public Collection<? extends Object> getDeprecatedBookNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DEPRECATEDBOOKNO, Object.class);
    }

    public boolean hasDeprecatedBookNo() {
		return !getDeprecatedBookNo().isEmpty();
    }

    public void addDeprecatedBookNo(Object newDeprecatedBookNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DEPRECATEDBOOKNO, newDeprecatedBookNo);
    }

    public void removeDeprecatedBookNo(Object oldDeprecatedBookNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DEPRECATEDBOOKNO, oldDeprecatedBookNo);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#deprecatedHadithNo
     */
     
    public Collection<? extends Object> getDeprecatedHadithNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DEPRECATEDHADITHNO, Object.class);
    }

    public boolean hasDeprecatedHadithNo() {
		return !getDeprecatedHadithNo().isEmpty();
    }

    public void addDeprecatedHadithNo(Object newDeprecatedHadithNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DEPRECATEDHADITHNO, newDeprecatedHadithNo);
    }

    public void removeDeprecatedHadithNo(Object oldDeprecatedHadithNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DEPRECATEDHADITHNO, oldDeprecatedHadithNo);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#endingHadithNo
     */
     
    public Collection<? extends Object> getEndingHadithNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ENDINGHADITHNO, Object.class);
    }

    public boolean hasEndingHadithNo() {
		return !getEndingHadithNo().isEmpty();
    }

    public void addEndingHadithNo(Object newEndingHadithNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ENDINGHADITHNO, newEndingHadithNo);
    }

    public void removeEndingHadithNo(Object oldEndingHadithNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ENDINGHADITHNO, oldEndingHadithNo);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#fullHadith
     */
     
    public Collection<? extends Object> getFullHadith() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_FULLHADITH, Object.class);
    }

    public boolean hasFullHadith() {
		return !getFullHadith().isEmpty();
    }

    public void addFullHadith(Object newFullHadith) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_FULLHADITH, newFullHadith);
    }

    public void removeFullHadith(Object oldFullHadith) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_FULLHADITH, oldFullHadith);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#hadithBookNo
     */
     
    public Collection<? extends Object> getHadithBookNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHBOOKNO, Object.class);
    }

    public boolean hasHadithBookNo() {
		return !getHadithBookNo().isEmpty();
    }

    public void addHadithBookNo(Object newHadithBookNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHBOOKNO, newHadithBookNo);
    }

    public void removeHadithBookNo(Object oldHadithBookNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHBOOKNO, oldHadithBookNo);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#hadithBookUrl
     */
     
    public Collection<? extends Object> getHadithBookUrl() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHBOOKURL, Object.class);
    }

    public boolean hasHadithBookUrl() {
		return !getHadithBookUrl().isEmpty();
    }

    public void addHadithBookUrl(Object newHadithBookUrl) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHBOOKURL, newHadithBookUrl);
    }

    public void removeHadithBookUrl(Object oldHadithBookUrl) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHBOOKURL, oldHadithBookUrl);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#hadithChapterIntro
     */
     
    public Collection<? extends Object> getHadithChapterIntro() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHCHAPTERINTRO, Object.class);
    }

    public boolean hasHadithChapterIntro() {
		return !getHadithChapterIntro().isEmpty();
    }

    public void addHadithChapterIntro(Object newHadithChapterIntro) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHCHAPTERINTRO, newHadithChapterIntro);
    }

    public void removeHadithChapterIntro(Object oldHadithChapterIntro) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHCHAPTERINTRO, oldHadithChapterIntro);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#hadithChapterNo
     */
     
    public Collection<? extends Object> getHadithChapterNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHCHAPTERNO, Object.class);
    }

    public boolean hasHadithChapterNo() {
		return !getHadithChapterNo().isEmpty();
    }

    public void addHadithChapterNo(Object newHadithChapterNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHCHAPTERNO, newHadithChapterNo);
    }

    public void removeHadithChapterNo(Object oldHadithChapterNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHCHAPTERNO, oldHadithChapterNo);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#hadithNo
     */
     
    public Collection<? extends Object> getHadithNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHNO, Object.class);
    }

    public boolean hasHadithNo() {
		return !getHadithNo().isEmpty();
    }

    public void addHadithNo(Object newHadithNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHNO, newHadithNo);
    }

    public void removeHadithNo(Object oldHadithNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHNO, oldHadithNo);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#hadithReferenceNo
     */
     
    public Collection<? extends Object> getHadithReferenceNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHREFERENCENO, Object.class);
    }

    public boolean hasHadithReferenceNo() {
		return !getHadithReferenceNo().isEmpty();
    }

    public void addHadithReferenceNo(Object newHadithReferenceNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHREFERENCENO, newHadithReferenceNo);
    }

    public void removeHadithReferenceNo(Object oldHadithReferenceNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHREFERENCENO, oldHadithReferenceNo);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#hadithText
     */
     
    public Collection<? extends Object> getHadithText() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHTEXT, Object.class);
    }

    public boolean hasHadithText() {
		return !getHadithText().isEmpty();
    }

    public void addHadithText(Object newHadithText) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHTEXT, newHadithText);
    }

    public void removeHadithText(Object oldHadithText) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHTEXT, oldHadithText);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#hadithUrl
     */
     
    public Collection<? extends Object> getHadithUrl() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHURL, Object.class);
    }

    public boolean hasHadithUrl() {
		return !getHadithUrl().isEmpty();
    }

    public void addHadithUrl(Object newHadithUrl) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHURL, newHadithUrl);
    }

    public void removeHadithUrl(Object oldHadithUrl) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHURL, oldHadithUrl);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#hadithVolumeNo
     */
     
    public Collection<? extends Object> getHadithVolumeNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHVOLUMENO, Object.class);
    }

    public boolean hasHadithVolumeNo() {
		return !getHadithVolumeNo().isEmpty();
    }

    public void addHadithVolumeNo(Object newHadithVolumeNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHVOLUMENO, newHadithVolumeNo);
    }

    public void removeHadithVolumeNo(Object oldHadithVolumeNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HADITHVOLUMENO, oldHadithVolumeNo);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#inBookNo
     */
     
    public Collection<? extends Object> getInBookNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_INBOOKNO, Object.class);
    }

    public boolean hasInBookNo() {
		return !getInBookNo().isEmpty();
    }

    public void addInBookNo(Object newInBookNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_INBOOKNO, newInBookNo);
    }

    public void removeInBookNo(Object oldInBookNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_INBOOKNO, oldInBookNo);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#narratorChain
     */
     
    public Collection<? extends Object> getNarratorChain() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_NARRATORCHAIN, Object.class);
    }

    public boolean hasNarratorChain() {
		return !getNarratorChain().isEmpty();
    }

    public void addNarratorChain(Object newNarratorChain) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_NARRATORCHAIN, newNarratorChain);
    }

    public void removeNarratorChain(Object oldNarratorChain) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_NARRATORCHAIN, oldNarratorChain);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#sameAs
     */
     
    public Collection<? extends Object> getSameAs() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_SAMEAS, Object.class);
    }

    public boolean hasSameAs() {
		return !getSameAs().isEmpty();
    }

    public void addSameAs(Object newSameAs) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_SAMEAS, newSameAs);
    }

    public void removeSameAs(Object oldSameAs) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_SAMEAS, oldSameAs);
    }


    /* ***************************************************
     * Data Property http://www.lodislamica.me/ontology/hadithVoc#startingHadithNo
     */
     
    public Collection<? extends Object> getStartingHadithNo() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_STARTINGHADITHNO, Object.class);
    }

    public boolean hasStartingHadithNo() {
		return !getStartingHadithNo().isEmpty();
    }

    public void addStartingHadithNo(Object newStartingHadithNo) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_STARTINGHADITHNO, newStartingHadithNo);
    }

    public void removeStartingHadithNo(Object oldStartingHadithNo) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_STARTINGHADITHNO, oldStartingHadithNo);
    }


    /* ***************************************************
     * Data Property https://www.w3.org/2000/01/rdf-schema#label
     */
     
    public Collection<? extends Object> getLabel() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_LABEL, Object.class);
    }

    public boolean hasLabel() {
		return !getLabel().isEmpty();
    }

    public void addLabel(Object newLabel) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_LABEL, newLabel);
    }

    public void removeLabel(Object oldLabel) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_LABEL, oldLabel);
    }


}