package com.Hiking.Trails;

import com.Hiking.Trails.controller.TrailController;
import com.Hiking.Trails.model.Trail;
import com.Hiking.Trails.repository.TrailRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TrailControllerTest {

    @InjectMocks
    private TrailController testTrailController;
    private List<Trail> TestTrailList;

    @Mock
    private TrailRepository trailRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        TestTrailList = new ArrayList<Trail>();
        Trail trail_1, trail_2, trail_3;
        trail_1 = new Trail(1L,"test 1", 3.1, "Easy", "Colorado Springs, CO", "First Test Trail" );
        trail_2 = new Trail(2L, "test 2", 5.1, "Moderate", "Boulder, CO", "Second Test Trail");
        trail_3 = new Trail(3L, "test 3", 1.5, "Hard", "Vail, CO", "Third Test Trail");
        TestTrailList.add(trail_1); TestTrailList.add(trail_2); TestTrailList.add(trail_3);
    }




    @Test
    public void testTrailList(){
        when(trailRepository.findAll()).thenReturn(TestTrailList);
        assertEquals(TestTrailList, testTrailController.list());
        verify(trailRepository).findAll();
    }


    @Test
    public void testTrailCreate(){
        Trail trail_1 = TestTrailList.get(0);
        when(trailRepository.saveAndFlush(trail_1)).thenReturn(TestTrailList.get(0));
        assertEquals(trail_1, testTrailController.create(trail_1));
        verify(trailRepository).saveAndFlush(trail_1);
    }

    @Test
    public void testTrailGet(){
        when(trailRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(TestTrailList.get(0)));

        Optional <Trail> result = testTrailController.get(1L);
        assertEquals(1L, TestTrailList.get(0).getId().longValue());
        verify(trailRepository).findById(1L);

    }

    @Test
    public void testTrailUpdate(){
        Trail editedTrail = TestTrailList.get(0);
        editedTrail.setDescription("updated");
        when(trailRepository.getOne(1L)).thenReturn(TestTrailList.get(0));
        when(trailRepository.saveAndFlush(editedTrail)).thenReturn(editedTrail);
        assertEquals(editedTrail, testTrailController.update(1L, editedTrail));
        verify(trailRepository).getOne(1L);
        verify(trailRepository).saveAndFlush(editedTrail);
    }

    @Test
    public void testTrailDelete(){
       Optional<Trail> deleted =  testTrailController.delete(2L);
        assertEquals(deleted, testTrailController.get(2L));
        verify(trailRepository).deleteById(2L);
    }
}
