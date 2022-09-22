package nuevopaquete

class Plecostumes (fishColor: FishColor = GoldColor) :
        /*AquariumFish(),*/ FishAction by PrintingFishAction("Eat algae"), FishColor by fishColor{
   //override val color: String = GoldColor.color
}