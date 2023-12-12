import { SplitedContainer } from "@/components/splited-container";
import { Button } from "@/components/ui/button";
import { HoverCard, HoverCardContent, HoverCardTrigger } from "@/components/ui/hover-card";


export function ProfileCard(){

    const profile = {
        login: "doutorwaka"
    }

    return (
        <HoverCard>
            <HoverCardTrigger className="cursor-pointer">{profile.login}</HoverCardTrigger>
            <HoverCardContent className="w-sm">
                <SplitedContainer>
                    <Button variant={"default"} className="w-full rounded-full">Seguir</Button>
                </SplitedContainer>
            </HoverCardContent>
        </HoverCard>
    )

}