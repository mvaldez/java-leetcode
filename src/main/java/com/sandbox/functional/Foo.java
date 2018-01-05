package com.sandbox.functional;



/**
 * TODO: JAVADOC ME
 *
 * @author {@link "mark.valdez@amd.com"}
 */
public class Foo {
   final String value;
   final Integer integer;

   public Foo(String value, Integer integer) {
      this.value = value;
      this.integer = integer;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Foo foo = (Foo) o;

      if (!value.equals(foo.value)) return false;
      return integer.equals(foo.integer);

   }

   @Override
   public int hashCode() {
      int result = value.hashCode();
      result = 31 * result + integer.hashCode();
      return result;
   }
}
