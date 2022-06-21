package htw.berlin.weatherbackend.service;

import htw.berlin.weatherbackend.persistence.CityEntity;
import htw.berlin.weatherbackend.persistence.CityRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest implements WithAssertions{

    @Mock
    private CityRepository repository;

    @InjectMocks
    private CityService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        // given
        Long givenId = 111L;
        doReturn(true).when(repository).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verify(repository).deleteById(givenId); //prüft das die Methode auf Repository aufegrufen wird
        assertThat(result).isTrue();
    }


    @Test
    @DisplayName("should return false if city to delete does not exist")
    void should_return_false_if_city_to_delete_does_not_exist() {
        // given
        Long givenId = 111L;
        doReturn(false).when(repository).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verifyNoMoreInteractions(repository); // prüft das auf Mock  keine Methode aufgerufen wird
        assertThat(result).isFalse(); //prüft dass das Ergebnis false ist
    }
    @Test
    @DisplayName("should transform CityEntity to Weatherofcity")
    void should_transform_city_entity_to_weatherofcity() {
        // given
        var cityEntity = Mockito.mock(CityEntity.class);
        doReturn(111L).when(cityEntity).getId();
        doReturn("Potsdam").when(cityEntity).getName();

        // when
        var result = underTest.transformEntity(cityEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getName()).isEqualTo("Potsdam");

    }
}
