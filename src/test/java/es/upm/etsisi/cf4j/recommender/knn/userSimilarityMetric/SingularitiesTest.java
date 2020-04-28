package es.upm.etsisi.cf4j.recommender.knn.userSimilarityMetric;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.MockDataSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SingularitiesTest {

    private static DataModel datamodel;

    @BeforeAll
    static void initAll() {
        datamodel = new DataModel(new MockDataSet());
    }

    @Test
    void similarity() {
        Singularities sim = new Singularities(new double[]{0.0,1.0,4.0}, new double[]{2.0,3.0});
        sim.setDatamodel(datamodel);
        sim.beforeRun();
        assertEquals(0.09765625,sim.similarity(datamodel.getUser(0),datamodel.getUser(1)));
        assertEquals(0.057291666666666664,sim.similarity(datamodel.getUser(0),datamodel.getUser(3)));
        assertEquals(0.078125,sim.similarity(datamodel.getUser(1),datamodel.getUser(3)));
        assertTrue(sim.similarity(datamodel.getUser(0),datamodel.getUser(1))>sim.similarity(datamodel.getUser(0),datamodel.getUser(3)));
        assertTrue(sim.similarity(datamodel.getUser(0),datamodel.getUser(1))>sim.similarity(datamodel.getUser(1),datamodel.getUser(3)));
        assertTrue(sim.similarity(datamodel.getUser(1),datamodel.getUser(3))>sim.similarity(datamodel.getUser(0),datamodel.getUser(3)));
        sim.afterRun();
    }
}