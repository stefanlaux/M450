package ch.tbz.recipe.planner.mapper;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import ch.tbz.recipe.planner.domain.Unit;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class IngredientEntityMapperTest {

    private final IngredientEntityMapper mapper = Mappers.getMapper(IngredientEntityMapper.class);

    @Test
    void entityToDomain() {
        IngredientEntity entity = new IngredientEntity(UUID.randomUUID(), "Tomato", "Fresh", Unit.KILOGRAMM, 2);

        SoftAssertions softly = new SoftAssertions();
        Ingredient domain = mapper.entityToDomain(entity);

        softly.assertThat(domain.getId()).isEqualTo(entity.getId());
        softly.assertThat(domain.getName()).isEqualTo(entity.getName());
        softly.assertThat(domain.getComment()).isEqualTo(entity.getComment());
        softly.assertThat(domain.getUnit()).isEqualTo(entity.getUnit());
        softly.assertThat(domain.getAmount()).isEqualTo(entity.getAmount());

        softly.assertAll();
    }

    @Test
    void domainToEntity() {
        Ingredient domain = new Ingredient(UUID.randomUUID(), "Potato", "Organic", Unit.GRAMM, 500);

        SoftAssertions softly = new SoftAssertions();
        IngredientEntity entity = mapper.domainToEntity(domain);

        softly.assertThat(entity.getId()).isEqualTo(domain.getId());
        softly.assertThat(entity.getName()).isEqualTo(domain.getName());
        softly.assertThat(entity.getComment()).isEqualTo(domain.getComment());
        softly.assertThat(entity.getUnit()).isEqualTo(domain.getUnit());
        softly.assertThat(entity.getAmount()).isEqualTo(domain.getAmount());

        softly.assertAll();
    }

    @Test
    void entitiesToDomains() {
        List<IngredientEntity> entities = Arrays.asList(
                new IngredientEntity(UUID.randomUUID(), "Carrot", "Fresh", Unit.GRAMM, 200),
                new IngredientEntity(UUID.randomUUID(), "Cucumber", "Organic", Unit.PIECE, 1)
        );

        SoftAssertions softly = new SoftAssertions();
        List<Ingredient> domains = mapper.entitiesToDomains(entities);

        for (int i = 0; i < entities.size(); i++) {
            IngredientEntity entity = entities.get(i);
            Ingredient domain = domains.get(i);

            softly.assertThat(domain.getId()).isEqualTo(entity.getId());
            softly.assertThat(domain.getName()).isEqualTo(entity.getName());
            softly.assertThat(domain.getComment()).isEqualTo(entity.getComment());
            softly.assertThat(domain.getUnit()).isEqualTo(entity.getUnit());
            softly.assertThat(domain.getAmount()).isEqualTo(entity.getAmount());
        }

        softly.assertAll();
    }

    @Test
    void domainsToEntities() {
        List<Ingredient> domains = Arrays.asList(
                new Ingredient(UUID.randomUUID(), "Apple", "Sweet", Unit.KILOGRAMM, 1),
                new Ingredient(UUID.randomUUID(), "Banana", "Ripe", Unit.PIECE, 2)
        );

        SoftAssertions softly = new SoftAssertions();
        List<IngredientEntity> entities = mapper.domainsToEntities(domains);

        for (int i = 0; i < domains.size(); i++) {
            Ingredient domain = domains.get(i);
            IngredientEntity entity = entities.get(i);

            softly.assertThat(entity.getId()).isEqualTo(domain.getId());
            softly.assertThat(entity.getName()).isEqualTo(domain.getName());
            softly.assertThat(entity.getComment()).isEqualTo(domain.getComment());
            softly.assertThat(entity.getUnit()).isEqualTo(domain.getUnit());
            softly.assertThat(entity.getAmount()).isEqualTo(domain.getAmount());
        }

        softly.assertAll();
    }
}
