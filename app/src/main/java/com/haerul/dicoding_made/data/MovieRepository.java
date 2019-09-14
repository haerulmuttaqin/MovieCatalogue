package com.haerul.dicoding_made.data;

import com.haerul.dicoding_made.R;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    
    private List<Movie> movies = new ArrayList<>();
    private static MovieRepository movieRepository;

    private MovieRepository() {}

    public static synchronized MovieRepository getInstance( ) {
        if (movieRepository == null)
            movieRepository = new MovieRepository();
        return movieRepository;
    }

    public List<Movie> getMovieData() {
        movies.add(new Movie(
                "Fast & Furious Presents: Hobbs & Shaw", 
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw. ", 
                R.drawable.fastfurious,
                2019,
                5));
        
        movies.add(new Movie(
                "The Lion King",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his. ",
                R.drawable.thelionking,
                2019,
                3.5f));

        movies.add(new Movie(
                "Men in Black: International ",
                "The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization.",
                R.drawable.meninblack,
                2019,
                3.5f));

        movies.add(new Movie(
                "Avengers: Endgame",
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store. ",
                R.drawable.avengers,
                2019,
                5.0f));

        movies.add(new Movie(
                "Red Shoes and the Seven Dwarfs",
                "Princes who have been turned into Dwarfs seek the red shoes of a lady in order to break the spell, although it will not be easy. ",
                R.drawable.redshoes,
                2019,
                4));

        movies.add(new Movie(
                "Hello, Love, Goodbye ",
                "A love story of Joy and Ethan, Filipino workers based in Hong Kong. Ethan, a bartender, is keen on romantically pursuing Joy, a domestic helper who is wholly dedicated to providing for her family. ",
                R.drawable.hellolove,
                2019,
                3f));

        movies.add(new Movie(
                "Angel Has Fallen",
                "Secret Service Agent Mike Banning is framed for the attempted assassination of the President and must evade his own agency and the FBI as he tries to uncover the real threat. ",
                R.drawable.angelhasfalen,
                2019,
                3.5f));

        movies.add(new Movie(
                "Good Boys ",
                "A group of young boys on the cusp of becoming teenagers embark on an epic quest in the San Fernando Valley to fix their broken toy before their parents get home. ",
                R.drawable.goodboy,
                2019,
                4.0f));

        movies.add(new Movie(
                "John Wick: Chapter 3 – Parabellum ",
                "Super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn. ",
                R.drawable.johnwick,
                2019,
                4.5f));

        movies.add(new Movie(
                "Godzilla: King of the Monsters ",
                "Follows the heroic efforts of the crypto-zoological agency Monarch as its members face off against a battery of god-sized monsters, including the mighty Godzilla, who collides with Mothra, Rodan, and his ultimate nemesis, the three-headed King Ghidorah. When these ancient super-species - thought to be mere myths - rise again, they all vie for supremacy, leaving humanity's very existence hanging in the balance. ",
                R.drawable.angelhasfalen,
                2019,
                4.0f));
        
        return movies;
    }
    
}
