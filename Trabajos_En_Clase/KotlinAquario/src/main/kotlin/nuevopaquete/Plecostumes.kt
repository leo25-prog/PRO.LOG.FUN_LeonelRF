package nuevopaquete

//class Plecostumes : AquariumFish(), FishAction{
//class Plecostumes : FishAction, FishColor by GoldColor{
class Plecostumes (fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("Eat algae"), FishColor by fishColor{
   //override val color: String = GoldColor.color
}