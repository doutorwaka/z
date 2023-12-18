import { Input } from "@/components/ui/input";
import { services } from "@/services";
import { Search } from "lucide-react";

async function searchProfile(profile: string) {
    try {
        const { profiles } = await services.profile.search({ profile });
        return profiles;
    } catch (error) {
        return [];
    }
}

export function PageSearch() {
    return (
        <div className="flex w-full items-center py-4">
            <Search className="text-muted-foreground relative left-10 top-3 transform -translate-y-1/2" />
            <Input
                placeholder="Busque alguém para seguir..."
                className="pl-12 rounded-full font-light text-lg"
            />
        </div>
    );
}
