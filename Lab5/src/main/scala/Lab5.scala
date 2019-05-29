import scala.annotation.tailrec
import scala.collection.mutable

object Lab5 {

  def main(args: Array[String]): Unit = {

    val vector1 = Vector[Int](-12, -13, 12)
    val vector2 = Vector[Int](1, 2, 3)
    println(getVectMulTailrec(vector1, vector2))
    println(getVectMul(vector1, vector2))

  }

  def getVectMulTailrec(firstVector: Vector[Int], secondVector: Vector[Int]): Vector[Int] = {
    val length = firstVector.length

    @tailrec
    def getVect(resultVector: Vector[Int], firstVector: Vector[Int], secondVector: Vector[Int], sizeOfList: Int): Vector[Int] = {
      if (sizeOfList >= length)
        resultVector
      else
        getVect(resultVector ++ Vector(firstVector(sizeOfList) * secondVector(sizeOfList)), firstVector, secondVector, sizeOfList + 1)
    }

    getVect(Vector(), firstVector, secondVector, 0)
  }

  def getVectMul(firstVector: Vector[Int], secondVector: Vector[Int]) : Vector[Int] = {
    val size = firstVector.length
    val resultVector = Vector()

    def getVect(result: Vector[Int], first: Vector[Int], second: Vector[Int], i: Int): Vector[Int] = {
      if (i == size)
        result
      else
        resultVector ++ getVect(result ++ Vector(first(i)*second(i)), first, second, i+1)
    }

    getVect(Vector(), firstVector, secondVector, 0)
  }

}
