package org.cbioportal.service;

import org.cbioportal.model.Mutation;
import org.cbioportal.model.MutationCount;
import org.cbioportal.model.MutationCountByPosition;
import org.cbioportal.model.MutationCountByGene;
import org.cbioportal.model.meta.MutationMeta;
import org.cbioportal.service.exception.MolecularProfileNotFoundException;

import java.util.List;

public interface MutationService {
    
    List<Mutation> getMutationsInMolecularProfileBySampleListId(String molecularProfileId, String sampleListId,
                                                                List<Integer> entrezGeneIds, Boolean snpOnly,
                                                                String projection, Integer pageSize, Integer pageNumber,
                                                                String sortBy, String direction) 
        throws MolecularProfileNotFoundException;

    MutationMeta getMetaMutationsInMolecularProfileBySampleListId(String molecularProfileId, String sampleListId,
                                                                  List<Integer> entrezGeneIds) 
        throws MolecularProfileNotFoundException;

    List<Mutation> getMutationsInMultipleMolecularProfiles(List<String> molecularProfileIds, List<String> sampleIds,
                                                           List<Integer> entrezGeneIds, String projection,
                                                           Integer pageSize, Integer pageNumber,
                                                           String sortBy, String direction);

    MutationMeta getMetaMutationsInMultipleMolecularProfiles(List<String> molecularProfileIds, List<String> sampleIds,
                                                             List<Integer> entrezGeneIds);

    List<Mutation> fetchMutationsInMolecularProfile(String molecularProfileId, List<String> sampleIds,
                                                    List<Integer> entrezGeneIds, Boolean snpOnly, String projection,
                                                    Integer pageSize, Integer pageNumber, String sortBy, 
                                                    String direction) 
        throws MolecularProfileNotFoundException;

    MutationMeta fetchMetaMutationsInMolecularProfile(String molecularProfileId, List<String> sampleIds,
                                                      List<Integer> entrezGeneIds) 
        throws MolecularProfileNotFoundException;

    List<MutationCountByGene> getSampleCountByEntrezGeneIdsAndSampleIds(String molecularProfileId,
                                                                        List<String> sampleIds,
                                                                        List<Integer> entrezGeneIds)
        throws MolecularProfileNotFoundException;

    List<MutationCountByGene> getPatientCountByEntrezGeneIdsAndSampleIds(String molecularProfileId,
                                                                        List<String> patientIds,
                                                                        List<Integer> entrezGeneIds)
        throws MolecularProfileNotFoundException;

    List<MutationCount> getMutationCountsInMolecularProfileBySampleListId(String molecularProfileId, String sampleListId) 
        throws MolecularProfileNotFoundException;

    List<MutationCount> fetchMutationCountsInMolecularProfile(String molecularProfileId, List<String> sampleIds) 
        throws MolecularProfileNotFoundException;

    List<MutationCountByPosition> fetchMutationCountsByPosition(List<Integer> entrezGeneIds, 
                                                                List<Integer> proteinPosStarts, 
                                                                List<Integer> proteinPosEnds);
}
