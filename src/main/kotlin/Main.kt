/*
レベル上げの関数を作る。
「経験値を与えてください。」に対して数値を入力。
一定の経験値が溜まったら「レベルが上がりました。レベル○○になりました」と表示
一気に経験値を獲得した場合にレベルが２以上上がることにも対応。
表示するのは現レベル、合計経験値、あとどれくらいでレベルアップするのか
カンストを設定
 */

fun main(args: Array<String>) {
    var totalExperience = 0 // 合計経験値
    var level = 0 // 現在のレベル
    while (level < 100) {
        println("LV : ${level}")
        println("EXP : ${totalExperience}\n")
        println("Enter your experience.")
        val input = readLine()
        if (input == null || input == "q") break

        val experience = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            println("Invalid input: Please enter an integer value.")
            continue
        }

        totalExperience += experience
        while (totalExperience >= getNextLevelExperience(level)) {
            level++
            println("LEVEL UP!! You are now level $level!!")
        }
    }
    if (level >= 100) {
        println("Congratulations! You have reached level 100!!!!!!!")
    }
}


fun getNextLevelExperience(level: Int): Int {
    return when (level) {
        in 0..99 -> 100 * (level + 1)
        else -> Int.MAX_VALUE // レベル100でカンスト
    }
}




/*
fun main(args: Array<String>) {
    var totalExperience = 0 // 合計経験値
    var level = 0 // 現レベル
    var expcount = 0 // レベルが上がるまでのカウント
    while(level <100){
        println("LV : ${level}")
        println("EXP : ${totalExperience}\n")
        println("Enter your experience.")
        var input = readLine()
        if (input == null || input == "q") break
        totalExperience += input.toInt()
        expcount += input.toInt()
        if(expcount > 1000){
            expcount = 0
            level++
        }
    }
    if (level >= 100) {
        println("Congratulations! You have reached level 100!!!!!!!")
    }
}
*/