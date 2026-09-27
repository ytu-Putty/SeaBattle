//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main()
{
    val playerfield = createEmptyField(8)
    playerfield[3][2] = '#'
    playerfield[3][3] = '#'
    playerfield[3][4] = '#'
    playerfield[3][5] = '#'

    val enemyfield = createEmptyField(8)
    enemyfield[5][7] = '#'
    enemyfield[6][7] = 'x'
    enemyfield[7][7] = '0'

    val thirdField = createEmptyField(8)
    thirdField[1][1] = '#'
    thirdField[2][2] = '#'

    val fields = arrayOf(playerfield, enemyfield, thirdField)
    val titles = arrayOf("Ваше поле", "Противник", "Третье")
    val show = booleanArrayOf(true, false, false)

    printField(playerfield, "Ваше поле", true, false)
    printField(enemyfield, "Вражеское поле", false, true)
    printFields(fields, titles, show)
}
fun createEmptyField(size: Int = 10): Array<CharArray>
{
    return Array(size) {CharArray(size) {'.'} }
}
fun printField(field:Array<CharArray>, title: String, showShips: Boolean = true, debug: Boolean = false)
{
    if(debug)
    {
        val size = field.size
        println("=== $title (debug)===")
        print("    |")
        for (c in 0..field.size-1) {
            if( c > 9)
            {
                print("$c |")
            }
            else print(" $c |")
        }
        println()

        for (r in 0..field.size-1) {
            print("    ")
            println("+---".repeat(size) + "+")
            if( r > 9)
            {
                print(" $r |")
            }
            else print(" $r  |")

            for (c in 0..field.size-1) {
                val value = field[r][c]
                val displayChar = if (value == '#' && !showShips) '.' else value
                print(" $displayChar |")
            }
            println()
        }
        print("    ")
        println("+---".repeat(size) + "+")
    }
    else
    {
        println("=== $title===")
        print("   ")
        for (c in 0..field.size-1) {
            print("$c ")
        }
        println()
        for (r in 0..field.size-1) {
            print(" $r ")
            for (c in 0..field.size-1) {
                val value = field[r][c]
                val displayChar = if (value == '#' && !showShips) '.' else value
                print("$displayChar ")
            }
            println()
        }
    }

}
fun printBothFields(player: Array<CharArray>, enemy: Array<CharArray>, showEnemyShips: Boolean = false)
{
    if (player.size != enemy.size) {
        println("Ошибка: невозможно вывести поля рядом, так как их размеры различаются.")
        return
    }
    val size = player.size
    println("=== Ваше поле ===        === Поле противника ===")
    print("  ")
    for (c in 0..size-1) print("$c ")
    print("     ")
    print("   ")
    for(c in 0..size-1) print("$c ")
    println()

    for (r in 0..size-1) {
        print("$r ")
        for (c in 0..size-1) print("${player[r][c]} ")
        print("      ")
        print("$r ")

        for (c in 0..size-1)
        {
            val value = enemy[r][c]
            val displayChar = if (value == '#' && !showEnemyShips) '.' else value
            print("$displayChar ")
        }

        println()
    }
}
fun printFields(fields: Array<Array<CharArray>>, titles: Array<String>, showShips: BooleanArray)
{
    if (fields.size != titles.size || fields.size != showShips.size) {
        println("Ошибка: количество полей (${fields.size}), заголовков (${titles.size}) и флагов (${showShips.size}) не совпадает.")
        return
    }
    if (fields.isEmpty()) {
        println("Ошибка: передан пустой список полей.")
        return
    }
    val size = fields[0].size
    for (field in fields)
    {
        if (field.size != size) {
            println("Ошибка: размеры полей различаются.")
            return
        }
    }

    for (i in fields.indices) {
        print("=== ${titles[i]} ===")
        if (i != fields.lastIndex) {
            print("       ")
        }
    }

    println()

    for (i in fields.indices) {
        print("   ")
        for (c in 0 .. size-1) {
            print("$c ")
        }
        print("   ")
    }
    println()

    println()

    for (r in 0 .. size-1)
    {
        for (i in 0..fields.size-1)
        {
            print (" $r ")
            for (c in 0 .. size-1) {
                val value = fields[i][r][c]
                val displayChar = if (value == '#' && !showShips[i]) '.' else value
                print("$displayChar ")
            }
            print("   ")
        }
        println()
    }
}

