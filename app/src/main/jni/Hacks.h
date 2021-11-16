#ifndef HACKS_H
#define HACKS_H

#include "socket.h"

Request request;
Response response;
float x,y;
char extra[30];
int botCount,playerCount;
Color clr, clrHealth;

Options options{1, -1, 3, false, 1, false, 401};

//Line And Alert Colour
Color colorByDistance(int distance, float alpha){
    Color _colorByDistance;
    if (distance < 600)
        _colorByDistance = Color(154,120,26, alpha); //Orange Black
    if (distance < 450)
        _colorByDistance = Color(21,94,34, alpha); //Green Black
    if (distance < 350)
        _colorByDistance = Color(101,119,23, alpha); //Yellow Black
    if (distance < 250)
        _colorByDistance = Color(6,25,87, alpha); //Blue Black
    if (distance < 150)
        _colorByDistance = Color(102,255,0, alpha); //Green
    if (distance < 90)
        _colorByDistance = Color(255,127,50, alpha); //Orange
    return _colorByDistance;
}

void DrawESP(ESP esp, int screenWidth, int screenHeight) {

    botCount=0;playerCount=0;
    request.ScreenHeight=screenHeight;
    request.ScreenWidth=screenWidth;
    request.Mode=InitMode;
    request.options=options;
    send((void*)&request,sizeof(request));
    receive((void*)&response);


    esp.DrawTextName(Color::White(), "",
                     Vec2(screenWidth / 2 + screenHeight / 40 + 50, screenHeight / 10.8 - 5),
                     screenHeight / 35);

    if(response.Success) {
        float textsize=screenHeight/50;
        for (int i = 0; i < response.PlayerCount; i++) {
            x = response.Players[i].HeadLocation.x;
            y = response.Players[i].HeadLocation.y;
            if (response.Players[i].isBot) {
                botCount++;
                clr.r = 255;
                clr.g = 255;
                clr.b = 255;
                clr.a = 255;
            } else {
                playerCount++;
                clr.r = 255;
                clr.g = 0;
                clr.b = 0;
                clr.a = 255;
            }
            float magic_number = (response.Players[i].Distance * response.fov);
            float mz = (screenWidth / 1.20) / magic_number;
            float mx = (screenWidth / 4) / magic_number;
            float my = (screenWidth / 1.38) / magic_number;
            float top = y - my + (screenWidth / 1.7) / magic_number;
            float bottom = y + my + screenHeight / 4 / magic_number;
            Color _colorByDistance = colorByDistance((int)response.Players[i].Distance, 100);
           // Color _colorSkeletonDistance = colorSkeletonDistance((int)response.Players[i].Distance, 90);
          //Color _colorBoxDistance = colorBoxDistance((int)response.Players[i].Distance, 100);

            if(options.openState==0)
                esp.DrawCircle(Color::Green(), //Color Fov
                               Vec2(screenWidth/2,screenHeight/2),request.options.aimingRange,screenHeight/200);
            if (response.Players[i].HeadLocation.z != 1) {
                if (x > -50 && x < screenWidth + 50) { //onScreen
                    if (isSkelton && response.Players[i].Bone.isBone){  //Skelton
                        if (y > screenHeight / 2 - mz && y < screenHeight / 2 + mx && x > screenWidth / 2 - mx && x < screenWidth / 2 + mx) {
                            clrHealth = Color::Green();
                            if (response.Players[i].isBot) {

                            } else {
                                esp.DrawFilledRect(Color(0,255,0,38),
                                                   Vec2(x - mx, top),
                                                   Vec2(x + mx, bottom));

                            }
                        }else{

                            clrHealth = Color::White();

                            }


                        esp.DrawLine(clrHealth, 2.1, Vec2(x, y),
                                     Vec2(response.Players[i].Bone.neck.x,
                                          response.Players[i].Bone.neck.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.neck.x,
                                                          response.Players[i].Bone.neck.y),
                                     Vec2(response.Players[i].Bone.cheast.x,
                                          response.Players[i].Bone.cheast.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.cheast.x,
                                                          response.Players[i].Bone.cheast.y),
                                     Vec2(response.Players[i].Bone.pelvis.x,
                                          response.Players[i].Bone.pelvis.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.neck.x,
                                                          response.Players[i].Bone.neck.y),
                                     Vec2(response.Players[i].Bone.lSh.x,
                                          response.Players[i].Bone.lSh.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.neck.x,
                                                          response.Players[i].Bone.neck.y),
                                     Vec2(response.Players[i].Bone.rSh.x,
                                          response.Players[i].Bone.rSh.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.lSh.x,
                                                          response.Players[i].Bone.lSh.y),
                                     Vec2(response.Players[i].Bone.lElb.x,
                                          response.Players[i].Bone.lElb.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.rSh.x,
                                                          response.Players[i].Bone.rSh.y),
                                     Vec2(response.Players[i].Bone.rElb.x,
                                          response.Players[i].Bone.rElb.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.lElb.x,
                                                          response.Players[i].Bone.lElb.y),
                                     Vec2(response.Players[i].Bone.lWr.x,
                                          response.Players[i].Bone.lWr.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.rElb.x,
                                                          response.Players[i].Bone.rElb.y),
                                     Vec2(response.Players[i].Bone.rWr.x,
                                          response.Players[i].Bone.rWr.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.pelvis.x,
                                                          response.Players[i].Bone.pelvis.y),
                                     Vec2(response.Players[i].Bone.lTh.x,
                                          response.Players[i].Bone.lTh.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.pelvis.x,
                                                          response.Players[i].Bone.pelvis.y),
                                     Vec2(response.Players[i].Bone.rTh.x,
                                          response.Players[i].Bone.rTh.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.lTh.x,
                                                          response.Players[i].Bone.lTh.y),
                                     Vec2(response.Players[i].Bone.lKn.x,
                                          response.Players[i].Bone.lKn.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.rTh.x,
                                                          response.Players[i].Bone.rTh.y),
                                     Vec2(response.Players[i].Bone.rKn.x,
                                          response.Players[i].Bone.rKn.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.lKn.x,
                                                          response.Players[i].Bone.lKn.y),
                                     Vec2(response.Players[i].Bone.lAn.x,
                                          response.Players[i].Bone.lAn.y));
                        esp.DrawLine(clrHealth, 2.1, Vec2(response.Players[i].Bone.rKn.x,
                                                          response.Players[i].Bone.rKn.y),
                                     Vec2(response.Players[i].Bone.rAn.x,
                                          response.Players[i].Bone.rAn.y));
                    }


                    //Box
                    if (isPlayerBox) {
                        if (response.Players[i].isBot) {
                            if (y > screenHeight / 2 - mz && y < screenHeight / 2 + mx && x > screenWidth / 2 - mx && x < screenWidth / 2 + mx) {

                                esp.DrawRect(Color::Green(), //Bot
                                             screenHeight / 365, Vec2(x - mx, top),
                                             Vec2(x + mx, bottom));
                            }else{
                                esp.DrawRect(Color::Red(), //Bot
                                             screenHeight / 365, Vec2(x - mx, top),
                                             Vec2(x + mx, bottom));
                            }
                        } else {
                            if (y > screenHeight / 2 - mz && y < screenHeight / 2 + mx && x > screenWidth / 2 - mx && x < screenWidth / 2 + mx) {

                                esp.DrawRect(Color::Green(), //enemy
                                             screenHeight / 365, Vec2(x - mx, top),
                                             Vec2(x + mx, bottom));
                            }else{
                                        esp.DrawRect(Color::Red(), //enemy
                                                     screenHeight / 365, Vec2(x - mx, top),
                                        Vec2(x + mx, bottom));
                            }



                        }
                    }

                 /*   if (isPlayerBoxFill) {
                        if (response.Players[i].isBot) {
                            esp.DrawFilledRect(Color(_colorBoxDistance),
                                               Vec2(x - mx, top),
                                               Vec2(x + mx, bottom));
                            esp.DrawRect(Color(_colorSkeletonDistance),
                                         screenHeight / 500, Vec2(x - mx, top),
                                         Vec2(x + mx, bottom));
                        } else {
                            esp.DrawFilledRect(Color(_colorBoxDistance),
                                               Vec2(x - mx, top),
                                               Vec2(x + mx, bottom));
                            esp.DrawRect(Color(_colorSkeletonDistance),
                                         screenHeight / 500, Vec2(x - mx, top),
                                         Vec2(x + mx, bottom));
                        }
                    }*/

                    //Health
                    if (isPlayerHealth) {
                        float healthLength = screenWidth / 61;
                        if (healthLength < mx)
                            healthLength = mx;
                        if (response.Players[i].Health < 25)
                            clrHealth = Color(255, 0, 0);
                        else if (response.Players[i].Health < 50)
                            clrHealth = Color(255, 205, 0);
                        else if (response.Players[i].Health < 75)
                            clrHealth = Color(255, 255, 0);
                        else
                            clrHealth = Color(0, 255, 0);
                        if (response.Players[i].Health == 0)
                            esp.DrawText(Color(255, 0, 0), "Knocked",
                                         Vec2(x, top - screenHeight / 225), textsize);
                        else {
                            esp.DrawFilledRect3(clrHealth,
                                                Vec2(x - healthLength, top - screenHeight / 110),
                                                Vec2(x - healthLength +
                                                     (2 * healthLength) *
                                                     response.Players[i].Health /
                                                     100, top - screenHeight / 225));
                            esp.DrawRect2(Color(0, 0, 0), screenHeight / 660,
                                          Vec2(x - healthLength, top - screenHeight / 110),
                                          Vec2(x + healthLength, top - screenHeight / 225));
                        }
                    }
                    //Head
                    if (isPlayerHead) {
                        if (y > screenHeight / 2 - mz && y < screenHeight / 2 + mx && x > screenWidth / 2 - mx && x < screenWidth / 2 + mx) {
                            clrHealth = Color::Green();
                        }else{
                            clrHealth = Color::White();
                        }
                        esp.DrawHead(clrHealth,
                                     Vec2(response.Players[i].HeadLocation.x,
                                          response.Players[i].HeadLocation.y),
                                     screenHeight / 12 / magic_number);

                    }
                    //Name and distance
                    if (isPlayerName)
                        esp.DrawName(Color::White(), response.Players[i].PlayerNameByte,
                                     response.Players[i].TeamID,
                                     Vec2(x, top - 28), textsize);
                    if (isPlayerDist) {
                        sprintf(extra, "%0.0fM", response.Players[i].Distance);
                        esp.DrawTextDistance(Color::White(), extra,
                                             Vec2(x + 140, top - 28),
                                             textsize);
                    }
                    //weapon
                    if (isEnemyWeapon && response.Players[i].Weapon.isWeapon)
                        esp.DrawWeapon(Color(255, 255, 255), response.Players[i].Weapon.id,
                                       response.Players[i].Weapon.ammo,
                                       Vec2(x, top - 70), textsize);
                }
            }
            //360 Alert
            if (response.Players[i].HeadLocation.z == 1.0f) {
                if(!isr360Alert)
                    continue;
                if (y > screenHeight - screenHeight / 12)
                    y = screenHeight - screenHeight / 12;
                else if (y < screenHeight / 12)
                    y = screenHeight / 12;
                if (x < screenWidth / 2) {
                    esp.DrawFilledCircle(Color(_colorByDistance), Vec2(screenWidth, y),
                                         screenHeight / 18);
                    sprintf(extra, "%0.0f m", response.Players[i].Distance);
                    esp.DrawTextAltert(Color::White(), extra,
                                       Vec2(screenWidth - screenWidth / 80, y), textsize);
                } else {
                    esp.DrawFilledCircle(Color(_colorByDistance), Vec2(0, y),
                                         screenHeight / 18);
                    sprintf(extra, "%0.0f m", response.Players[i].Distance);
                    esp.DrawTextAltert(Color::White(), extra,
                                       Vec2(screenWidth / 80, y), textsize);
                }
            }
            else if (x < -screenWidth / 10 || x > screenWidth + screenWidth / 10) {
                if(!isr360Alert)
                    continue;
                if (y > screenHeight - screenHeight / 12)
                    y = screenHeight - screenHeight / 12;
                else if (y < screenHeight / 12)
                    y = screenHeight / 12;
                if (x > screenWidth / 2) {
                    esp.DrawFilledCircle(Color(_colorByDistance), Vec2(screenWidth, y),
                                         screenHeight / 18);
                    sprintf(extra, "%0.0f m", response.Players[i].Distance);
                    esp.DrawTextAltert(Color::White(), extra,
                                       Vec2(screenWidth - screenWidth / 80, y), textsize);
                } else {
                    esp.DrawFilledCircle(Color(_colorByDistance), Vec2(0, y),
                                         screenHeight / 18);
                    sprintf(extra, "%0.0f m", response.Players[i].Distance);
                    esp.DrawTextAltert(Color::White(), extra,
                                       Vec2(screenWidth / 80, y), textsize);
                }
            }
            else if(isPlayerLineTop) //Line Top
                esp.DrawLine(Color(_colorByDistance), screenHeight / 500,
                             Vec2(screenWidth / 2, screenHeight / 200 + -5), Vec2(x, top));
            else if (isPlayerLineMiddle) //Line Middle
                esp.DrawLine(Color(_colorByDistance), screenHeight / 500,
                             Vec2(screenWidth / 2, screenHeight / 2), Vec2(x, top));
            else if (isPlayerLineBottom) //line Bottom
                esp.DrawLine(Color(_colorByDistance), screenHeight / 500,
                             Vec2(screenWidth / 2, screenHeight), Vec2(x, top));
        }

        if(true)
        {



            if (playerCount == 0)
            {

            }
            if (botCount == 0)
            {

            }

            char cn[10];

            sprintf(cn,"(%d) |",playerCount);

            char bt[10];
            sprintf(bt,"%d Bots",botCount);

            esp.DrawText(Color::Green(), cn, Vec2(screenWidth/2 + (25) , 130), 35);
            esp.DrawText(Color::Green(), bt, Vec2(screenWidth/2 + (125) , 130), 34);
            esp.DrawText(Color::Green(), "Nearby Action:", Vec2(screenWidth/2 - (140) , 130), 34);
           // esp.DrawText(Color::Green(), "(", Vec2(screenWidth/2 + (5) , 130), 35);
            //esp.DrawText(Color(255,153,102), ")", Vec2(screenWidth/2 + (180) , 130), 35);
        }

        for (int i = 0; i < response.GrenadeCount; i++){
            if(!isGrenadeWarning)
                continue;
          //  esp.DrawText(Color(255,127,50),"Warning : Throwable",Vec2(screenWidth/-50,screenHeight/-20),textsize);
            if(response.Grenade[i].Location.z!=1.0f){
                if(response.Grenade[i].type==1 )
                    esp.DrawText(Color(255,127,50),"Grenade",Vec2(response.Grenade[i].Location.x,response.Grenade[i].Location.y),textsize);
                else
                    esp.DrawText(Color(255, 158, 89),"Molotov",Vec2(response.Grenade[i].Location.x,response.Grenade[i].Location.y),textsize);
            }
        }
        for(int i = 0; i < response.VehicleCount; i++){
            if(response.Vehicles[i].Location.z!=1.0f) {
                esp.DrawVehicles(response.Vehicles[i].VehicleName,response.Vehicles[i].Distance,Vec2(response.Vehicles[i].Location.x,response.Vehicles[i].Location.y),textsize);

            }
        }
        for(int i = 0; i < response.ItemsCount; i++){
            if(response.Items[i].Location.z!=1.0f) {
                esp.DrawItems(response.Items[i].ItemName,response.Items[i].Distance,Vec2(response.Items[i].Location.x,response.Items[i].Location.y),textsize);
            }
        }
    }
}

#endif //DESI_ESP_IMPORTANT_HACKS_H
