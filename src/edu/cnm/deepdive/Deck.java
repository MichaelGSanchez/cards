package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * <code>Dec</code> implements a single deco of standard playing cards. Methods are
 * included for shuffling and dealing cards from the deck.
 *
 *   @author Michael Sanchez &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 *   @version 1.0
 */
public class Deck {

  private List<Card> stock;
  private List<Card> discard;

  /**
   * Initializes the deck with all 52 cards, in order. The
   * {@link #shuffle(Random)} method must be invoked after initialization, prior to
   * dealing any cards via the {@link #deal()} method.
   */
  public Deck(){
    stock = new ArrayList<>();
    discard = new LinkedList<>();
      for (Suit s : Suit.values()){
        for (Rank r : Rank.values()){
          Card c = new Card (r,s);
          discard.add(c);
        }
      }
  }

  /**
   * Returns all cards to the pile, and shuffles it, readying it for dealing.
   *
   * @param rng <strong>required</strong> source of randomness.
   */
  public void shuffle(Random rng){
    stock.addAll(discard);
    discard.clear();
    Collections.shuffle(stock, rng);
  }

  /**
   * Deals and returns one card from the top of the pile. if no cards are in
   * the pile, a {@link DeckEmptyException} will be thrown.
   *
   * @return single card from the top of pile.
   * @throws DeckEmptyException if no cards are in the pile.
   */
  public Card deal() throws DeckEmptyException {
    try {
      Card c = stock.remove(0);
      discard.add(c);
      return c;
    } catch (IndexOutOfBoundsException e) {
      throw new DeckEmptyException();
    }
  }

  /**
   * This exception is thrown when {@link #deal()} is invoked on an empty deck.
   */
  public static class DeckEmptyException extends IllegalStateException {

    public DeckEmptyException() {
    }

    public DeckEmptyException(String message) {
      super(message);
    }

    public DeckEmptyException(String message, Throwable cause) {
      super(message, cause);
    }

    public DeckEmptyException(Throwable cause) {
      super(cause);
    }

  }

}
