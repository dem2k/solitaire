# solitaire

@startuml
!theme mars
Class Field{
{static}+english()
{static}+european()
+jump()
+checkWin()
+field()
}


Interface Viewer{
+show()
+animate()
}

Interface Strategy{
+hasNext()
+getNext()
}

Class Controller{
-viewer
-strategy
-field
+start()
}

Class ConsoleViewer implements Viewer
Class TestStrategy implements Strategy

Viewer <-- Controller
Strategy <-- Controller  
Field <-- Controller

@enduml
