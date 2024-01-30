package ch.tbz.recipe.planner.mapper;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class RecipeEntityMapperTest {

    private final RecipeEntityMapper mapper = Mappers.getMapper(RecipeEntityMapper.class);

    @Test
    void entityToDomain() {
        List<IngredientEntity> ingredients = Arrays.asList(
                new IngredientEntity(UUID.randomUUID(), "Sugar", "Sweet", null, 100),
                new IngredientEntity(UUID.randomUUID(), "Flour", "White", null, 500)
        );
        RecipeEntity entity = new RecipeEntity(UUID.randomUUID(), "Chocolate Cake", "Delicious and rich", "image-url", ingredients);

        SoftAssertions softly = new SoftAssertions();
        Recipe domain = mapper.entityToDomain(entity);

        softly.assertThat(domain.getId()).isEqualTo(entity.getId());
        softly.assertThat(domain.getName()).isEqualTo(entity.getName());
        softly.assertThat(domain.getDescription()).isEqualTo(entity.getDescription());
        softly.assertThat(domain.getImageUrl()).isEqualTo(entity.getImageUrl());
        softly.assertThat(domain.getIngredients().size()).isEqualTo(entity.getIngredients().size());

        softly.assertAll();
    }

    @Test
    void domainToEntity() {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient(UUID.randomUUID(), "Butter", "Creamy", null, 200),
                new Ingredient(UUID.randomUUID(), "Egg", "Free-range", null, 3)
        );
        Recipe domain = new Recipe(UUID.randomUUID(), "Pancake", "Easy and quick", "pancake-image-url", ingredients);

        SoftAssertions softly = new SoftAssertions();
        RecipeEntity entity = mapper.domainToEntity(domain);

        softly.assertThat(entity.getId()).isEqualTo(domain.getId());
        softly.assertThat(entity.getName()).isEqualTo(domain.getName());
        softly.assertThat(entity.getDescription()).isEqualTo(domain.getDescription());
        softly.assertThat(entity.getImageUrl()).isEqualTo(domain.getImageUrl());
        softly.assertThat(entity.getIngredients().size()).isEqualTo(domain.getIngredients().size());

        softly.assertAll();
    }
}
