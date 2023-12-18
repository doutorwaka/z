import { SplitedContainer } from "@/components/splited-container";
import { Button } from "@/components/ui/button";
import { HoverCard, HoverCardContent, HoverCardTrigger } from "@/components/ui/hover-card";

export type ProfileCardProps = {
    profile: string;
}

export function ProfileCard({profile}: ProfileCardProps){

    return (
        <HoverCard>
            <HoverCardTrigger className="cursor-pointer">{profile}</HoverCardTrigger>
            <HoverCardContent className="w-sm">
                <SplitedContainer profile={profile}>
                    <Button variant={"default"} className="w-full rounded-full">Seguir</Button>
                </SplitedContainer>
            </HoverCardContent>
        </HoverCard>
    )

}