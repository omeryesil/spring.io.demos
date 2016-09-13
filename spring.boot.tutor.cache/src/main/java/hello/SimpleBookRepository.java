package hello;


public class SimpleBookRepository implements BookRepository {

    public Book getByIsbn (String isbn) {
        simulateSlowServie();

        return new Book (isbn, "Some book");
    }

    private void simulateSlowServie () {

        try {
            long time =3000L;
            Thread.sleep (time);

        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }


    }

}
