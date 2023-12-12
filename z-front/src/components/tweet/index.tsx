import { MessageCircle, Repeat2, Heart, BarChart2 } from 'lucide-react';
import { SplitedContainer } from "../splited-container";
import { ProfileCard } from './profile-card';

export function Tweet(){

    const profile = {
        login: "doutorwaka"
    }

    return (
        <SplitedContainer>
            <div className="flex flex-col w-full gap-2">
                <div>
                    <span className="underline">
                        <ProfileCard/>
                    </span>
                    <span className="font-light">{" "}33m</span>
                </div>
                
                <div>
                    O conteúdo do tweet vai aqui!
                </div>

                <div className="flex w-full justify-between">
                    <div className="flex gap-2 w-max items-center">
                        <MessageCircle />
                        <span className="font-light">0</span>
                    </div>

                    <div className="flex gap-2 w-max items-center">
                        <Repeat2 />
                        <span className="font-light">0</span>
                    </div>

                    <div className="flex gap-2 w-max items-center">
                        <Heart />
                        <span className="font-light">0</span>
                    </div>

                    <div className="flex gap-2 w-max items-center">
                        <BarChart2 />
                        <span className="font-light">0</span>
                    </div>
                </div>
            </div>
        </SplitedContainer>
    )
}