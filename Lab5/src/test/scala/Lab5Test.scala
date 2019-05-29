import org.scalatest._
import scala.collection.immutable

class Lab5Test extends FlatSpec with Matchers{

  it should "getVectMul equal getVectMulTailrec" in {

    val vector1 = Vector[Int](-12, -13, 3)
    val vector2 = Vector[Int](1, 2, 3)

    assert(Lab5.getVectMul(vector1, vector2) === Lab5.getVectMulTailrec(vector1, vector2))

  }

  it should "Multiplied vectors" in {

    val vect1 = Vector[Int](3, -4, -5)
    val vect2 = Vector[Int](0, 6, -12)

    Lab5.getVectMul(vect1, vect2) should be (immutable.Vector(0, -24, 60))
  }



  it should "Multiply empty vectors" in {

    val vect1 = Vector[Int]()
    val vect2 = Vector[Int]()

    Lab5.getVectMul(vect1, vect2) should be (immutable.Vector())

  }



  it should "Multiplied vectors tailrec" in {

    val vect1 = Vector[Int](3, -4, -5)
    val vect2 = Vector[Int](0, 6, -12)

    Lab5.getVectMulTailrec(vect1, vect2) should be (immutable.Vector(0, -24, 60))

  }



  it should "Multiply empty vectors tailrec" in {

    val vect1 = Vector[Int]()
    val vect2 = Vector[Int]()

    Lab5.getVectMulTailrec(vect1, vect2) should be (immutable.Vector())

  }

}
